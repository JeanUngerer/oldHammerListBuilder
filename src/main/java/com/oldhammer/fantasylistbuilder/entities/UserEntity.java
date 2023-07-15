package com.oldhammer.fantasylistbuilder.entities;

import com.oldhammer.fantasylistbuilder.constants.Provider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false)
    Long userId;

    @Enumerated(EnumType.STRING)
    private Provider provider;

    @Column(name = "email", unique = true, nullable = false, length = 50)
    String email;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    String userName;

    @Column(name = "displayes_login", nullable = false, length = 50)
    String login;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "firstname", length = 50)
    String firstName;

    @Column(name = "lastname", length = 50)
    String lastName;

    @Column(name = "phone_number", length = 15)
    String phoneNumber;

    @Column(name = "role", nullable = false)
    String roles;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id")
    List<ArmyListEntity> myLists;

}
