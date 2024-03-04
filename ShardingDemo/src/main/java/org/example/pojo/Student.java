package org.example.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private Integer sex;
    private String address;
    private String phone;
    private Date create_time;
    private Date update_time;
    private String deleted;
    private String teacher_id;
}
