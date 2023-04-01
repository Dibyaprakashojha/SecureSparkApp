package com.acxtech.securesparkapp.model;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @Column(length = 14)
    private String username;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String password;
}
