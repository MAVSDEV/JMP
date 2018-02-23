package com.epam.userapi.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * User.
 */
@Data
@XmlRootElement
public class User {

    private String id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String avatarUrl;
}