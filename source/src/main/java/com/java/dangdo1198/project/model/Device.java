package com.java.dangdo1198.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document(collection = "device")
public class Device {
    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("status")
    private String status;

    @Field("unique_id")
    private String uniqueId;

    @Field("post_code")
    private String postcode;

    @Field("phone")
    private String phone;

    @Field("req_person")
    private Person reqPerson;

    @Field("approval_person")
    private Person approvalPerson;

    @Field("req_date")
    private Date reqDate;

    @Field("approval_date")
    private Date approvalDate;

    @Field("latest_login_date")
    private Date latestLoginDate;

    public static class Person {
        private Long personId;
        private String personName;

        public Person() {};
        public Person (Long personId, String personName) {
            this.personId = personId;
            this.personName = personName;
        }

        public Long getPersonId() {
            return personId;
        }

        public void setPersonId(Long personId) {
            this.personId = personId;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }
    }
}
