package com.acxtech.securesparkapp.model;

import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userDetailsId;

    @Column(length = 25)
    private String fullName;

    private Long mobileNumber;

    @Column(length = 55)
    private String address;

    @Column(length = 55)
    private String skills;

    @Column(length = 55)
    private String hobbies;

    private String fileId;
}
