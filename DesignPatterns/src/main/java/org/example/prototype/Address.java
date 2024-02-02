package org.example.prototype;

import java.io.Serializable;

/**
 * @ClassName Address
 * @Description
 * @Author chenxu
 * @Date 2023/11/13 21:44
 **/
public class Address implements Serializable {
    private String city;

    public Address(String city) {
        this.city = city;
    }
}