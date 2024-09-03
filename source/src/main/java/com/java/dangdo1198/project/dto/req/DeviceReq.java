package com.java.dangdo1198.project.dto.req;

import com.java.dangdo1198.project.dto.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceReq implements Serializable {
    private String id;
    private String name;
    private String uniqueId;
    private String postcode;
    private String status;
    private String phone;
    private PersonDto reqPerson;
    private PersonDto approvalPerson;
    private Date reqDate;
    private Date approvalDate;
    private Date latestLoginDate;
}
