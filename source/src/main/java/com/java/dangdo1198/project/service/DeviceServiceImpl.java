package com.java.dangdo1198.project.service;

import com.java.dangdo1198.project.dao.DeviceDAO;
import com.java.dangdo1198.project.dto.PageDto;
import com.java.dangdo1198.project.dto.req.DeviceReq;
import com.java.dangdo1198.project.dto.res.DeviceRes;
import com.java.dangdo1198.project.mapper.DeviceMapper;
import com.java.dangdo1198.project.model.Device;
import com.java.dangdo1198.project.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceDAO deviceDAO;


    public DeviceServiceImpl(DeviceDAO deviceDAO) {
        this.deviceDAO = deviceDAO;
    }

    @Override
    public void save(DeviceReq deviceReq) {
        Device device = DeviceMapper.toDevice(deviceReq);
        deviceDAO.save(device);

    }

    @Override
    public void saveBulk(List<DeviceReq> lstDeviceReq) {
        List<Device> devices = DeviceMapper.toDevices(lstDeviceReq);
        deviceDAO.saveBulk(devices);
    }

    @Override
    public List<DeviceRes> getAllDevices(int page, int size) {
        List<Device> devices = deviceDAO.getAll(page, size);
        return DeviceMapper.toLstDeviceRes(devices);
    }

    @Override
    public List<DeviceRes> getAllDevicesByQuery(String reqDate, String txtSearch, int page, int size) {
        Date dateSearch = DateUtils.covertToDate(reqDate);
        List<Device> devices = deviceDAO.getByQueryFields(dateSearch, txtSearch, page, size);
        return DeviceMapper.toLstDeviceRes(devices);
    }

    @Override
    public PageDto<DeviceRes> getResultByPaging(String reqDate, String txtSearch, int page, int size) {
        Date dateSearch = DateUtils.covertToDate(reqDate);
        PageDto<Device> devicePage = deviceDAO.getResultByPaging(dateSearch, txtSearch, page, size);
        return DeviceMapper.toPageDeviceRes(devicePage);
    }
}
