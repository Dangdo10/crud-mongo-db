package com.java.dangdo1198.project.service;

import com.java.dangdo1198.project.dto.PageDto;
import com.java.dangdo1198.project.dto.req.DeviceReq;
import com.java.dangdo1198.project.dto.res.DeviceRes;

import java.util.List;


public interface DeviceService {

    void save(DeviceReq req);

    void saveBulk(List<DeviceReq> req);

    List<DeviceRes> getAllDevices(int page, int size);

    List<DeviceRes> getAllDevicesByQuery(String reqDate, String txtSearch, int page, int size);

    PageDto<DeviceRes> getResultByPaging(String reqDate, String txtSearch, int page, int size);

}
