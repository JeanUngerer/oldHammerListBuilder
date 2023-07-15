package com.oldhammer.fantasylistbuilder.models.user;


import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {
    Long userId;
    String provider;
    String email;
    String userName;
    String login;
    String password;
    String firstName;
    String lastName;
    String phoneNumber;
    String roles;
    Double balance;
}
