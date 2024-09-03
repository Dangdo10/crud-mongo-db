package com.java.dangdo1198.project.dao;

import com.java.dangdo1198.project.dto.PageDto;
import com.java.dangdo1198.project.model.Device;
import com.java.dangdo1198.project.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class DeviceDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(Device device) {
        mongoTemplate.save(device);

    }

    public void saveBulk(List<Device> devices) {
        mongoTemplate.insertAll(devices);
    }

    public List<Device> getAll(int page, int size) {
        Query query = new Query();
        int offset = page * size;
        query.skip(offset).limit(size);
        return mongoTemplate.find(query, Device.class);
    }

    public List<Device> getByQueryFields(Date dateSearch, String txtSearch, int page, int size) {
        Query query = new Query();

// Query 1 từ xem có tồn tại trên 1 trường hay không?
//        if (txtSearch != null && !txtSearch.isEmpty()) {
//            query.addCriteria(Criteria.where("name").regex(txtSearch, "i")); // 'i' để tìm kiếm không phân biệt chữ hoa, chữ thường
//        }
        if (Objects.nonNull(dateSearch))
            query.addCriteria(Criteria.where("req_date").gte(dateSearch).lt(DateUtils.getNextDay(dateSearch)));

        if (txtSearch != null && !txtSearch.isEmpty()) {
            Criteria criteria = new Criteria().orOperator(
                    Criteria.where("name").regex(txtSearch,"i"),
                    Criteria.where("phone").regex(txtSearch, "i"),
                    Criteria.where("post_code").regex(txtSearch, "i")
            );
            query.addCriteria(criteria);
        }


        int offset = page * size;
        query.skip(offset).limit(size);
        return mongoTemplate.find(query, Device.class);
    }

    public PageDto<Device> getResultByPaging(Date dateSearch, String txtSearch, int page, int size) {
        Query query = new Query();
        if (Objects.nonNull(dateSearch))
            query.addCriteria(Criteria.where("req_date").gte(dateSearch).lt(DateUtils.getNextDay(dateSearch)));

        if (txtSearch != null && !txtSearch.isEmpty()) {
            Criteria criteria = new Criteria().orOperator(
                    Criteria.where("name").regex(txtSearch,"i"),
                    Criteria.where("phone").regex(txtSearch, "i"),
                    Criteria.where("post_code").regex(txtSearch, "i")
            );
            query.addCriteria(criteria);
        }

        long totalRecords = mongoTemplate.count(query, Device.class);
        int totalPages = (int) Math.ceil((double) totalRecords / size);

        int offset = page * size;
        query.skip(offset).limit(size);
        List<Device> devices = mongoTemplate.find(query, Device.class);
        return PageDto.<Device>builder()
                .lstData(devices)
                .totalRecord(totalRecords)
                .totalPages(totalPages)
                .pageNum(page)
                .size(size)
                .build();
    }

}
