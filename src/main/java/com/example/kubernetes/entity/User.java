package com.example.kubernetes.entity;

import lombok.Data;

/**
 * @author liuhaozhen
 * @version Revision 1.0.0
 * @date 2019/9/20 16:21
 */
@Data
public class User {
    /**
     * id
     */
    private Integer id;

    /**
     * username
     */
    private String username;

    /**
     * password
     */
    private String password;

    /**
     * role
     */
    private String role;
}