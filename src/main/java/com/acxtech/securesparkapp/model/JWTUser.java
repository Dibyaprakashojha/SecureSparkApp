package com.acxtech.securesparkapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "users")
public class JWTUser {
    @Id
    @GeneratedValue
    private Long userId;

    private String username;

    private String fullName;

    private String password;

    public JWTUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public JWTUser(String username, String fullName, String password) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
    }
}
