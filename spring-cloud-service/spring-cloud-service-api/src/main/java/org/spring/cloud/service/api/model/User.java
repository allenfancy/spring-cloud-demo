package org.spring.cloud.service.api.model;

import java.io.Serializable;

import lombok.Data;

@Data
//@Builder
public class User implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private Integer sex;
    private String email;
    private String tel;
    private Integer countryID;
}
