package com.aladdin.data.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.Date;

/**
 * @author lgc
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id",columnDefinition = "bigint")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Field("name")
    @Column(name = "name" ,columnDefinition = "varchar(50)")
    private String name;

    @Field("password")
    @Column(name = "password" ,columnDefinition = "varchar(50)")
    private String password;

    @Field("address")
    @Column(name = "address" ,columnDefinition = "varchar(200)")
    private String address;

    @Field("create_time")
    @Column(name = "create_time" ,columnDefinition = "timestamp")
    private Date createTime;

    @Field("update_time")
    @Column(name = "update_time" ,columnDefinition = "timestamp")
    private Date UpdateTime;

    @Field("phone")
    @Column(name = "phone",columnDefinition = "varchar(12")
    private String phone;


    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}