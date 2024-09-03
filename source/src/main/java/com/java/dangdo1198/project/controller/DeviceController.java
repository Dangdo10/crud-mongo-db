package com.java.dangdo1198.project.controller;

import com.java.dangdo1198.project.dto.PageDto;
import com.java.dangdo1198.project.dto.req.DeviceReq;
import com.java.dangdo1198.project.dto.res.DeviceRes;
import com.java.dangdo1198.project.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping
    public String save(@RequestBody DeviceReq req) {
        deviceService.save(req);
        return "Lưu thành công!";
    }

    @PostMapping("/bulk")
    public String saveBulk(@RequestBody List<DeviceReq> req) {
        deviceService.saveBulk(req);
        return "Lưu hàng loạt thành công!";
    }

    @GetMapping
    public List<DeviceRes> getAllDevices(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                                         @RequestParam(value = "size", defaultValue = "10", required = false) Integer size) {
        return deviceService.getAllDevices(page, size);
    }

    @GetMapping("/query")
    public List<DeviceRes> getAllDevicesByQuery(@RequestParam(value = "reqDate") String reqDate,
                                                @RequestParam(value = "textSearch", required = false) String txtSearch,
                                                @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                                                @RequestParam(value = "size", defaultValue = "10", required = false) Integer size) {
        return deviceService.getAllDevicesByQuery(reqDate, txtSearch, page, size);
    }

    @GetMapping("/paging")
    public PageDto<DeviceRes> getResultByPaging(@RequestParam(value = "reqDate") String reqDate,
                                                @RequestParam(value = "textSearch", required = false) String txtSearch,
                                                @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                                                @RequestParam(value = "size", defaultValue = "10", required = false) Integer size) {
        return deviceService.getResultByPaging(reqDate, txtSearch, page, size);
    }

    //todo: api detail, api update, api delete

}
