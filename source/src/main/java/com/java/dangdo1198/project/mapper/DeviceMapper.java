package com.java.dangdo1198.project.mapper;

import com.java.dangdo1198.project.dto.PageDto;
import com.java.dangdo1198.project.dto.PersonDto;
import com.java.dangdo1198.project.dto.req.DeviceReq;
import com.java.dangdo1198.project.dto.res.DeviceRes;
import com.java.dangdo1198.project.model.Device;
import com.java.dangdo1198.project.utils.DateUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DeviceMapper {
    public static Device toDevice(DeviceReq deviceReq) {
        return Device.builder()
                .name(deviceReq.getName())
                .uniqueId(deviceReq.getUniqueId())
                .status(deviceReq.getStatus())
                .postcode(deviceReq.getPostcode())
                .phone(deviceReq.getPhone())
                .reqPerson(new Device.Person(deviceReq.getReqPerson().getId(), deviceReq.getReqPerson().getName()))
                .reqDate(DateUtils.getPreviousDay(new Date()))
                .build();
    }

    public static List<Device> toDevices(List<DeviceReq> lstDeviceReq) {
        return lstDeviceReq.stream().map(e -> toDevice(e)).collect(Collectors.toList());
    }

    public static DeviceRes toDeviceRes(Device device) {
        return DeviceRes.builder()
                .id(device.getId())
                .name(device.getName())
                .uniqueId(device.getUniqueId())
                .status(device.getStatus())
                .postcode(device.getPostcode())
                .phone(device.getPhone())
                .reqPerson(new PersonDto(device.getReqPerson().getPersonId(), device.getReqPerson().getPersonName()))
                .approvalPerson(new PersonDto(Objects.isNull(device.getApprovalPerson())
                                                            ? null : device.getApprovalPerson().getPersonId(),
                                              Objects.isNull(device.getApprovalPerson())
                                                            ? null : device.getApprovalPerson().getPersonName()))
                .approvalDate(Objects.isNull(device.getApprovalDate()) ? null : device.getApprovalDate())
                .reqDate(device.getReqDate())
                .latestLoginDate(device.getLatestLoginDate())
                .build();
    }

    public static List<DeviceRes> toLstDeviceRes(List<Device> devices) {
        return devices.stream().map(e -> toDeviceRes(e)).collect(Collectors.toList());
    }

    public static PageDto<DeviceRes> toPageDeviceRes(PageDto<Device> devicePage) {
        return PageDto.<DeviceRes>builder()
                .lstData(toLstDeviceRes(devicePage.getLstData()))
                .pageNum(devicePage.getPageNum())
                .size(devicePage.getSize())
                .totalPages(devicePage.getTotalPages())
                .totalRecord(devicePage.getTotalRecord())
                .build();
    }




}
