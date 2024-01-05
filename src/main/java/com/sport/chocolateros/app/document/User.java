package com.sport.chocolateros.app.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private String email;
    private String password;
    private String departament;
    private String district;
    private String address;
    private String phone;
    private String photo;
}
