package com.sevinc.furkan.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "users",indexes = {@Index(name = "idx_username",columnList = "uname")})
public class User extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name",length = 50,unique = true) //unigue başkası tarafından kullanılamaz hale getiriyor
    private String username;

    @Column(name = "name_surname",length = 50)
    private String nameSurname;

    @Column(name = "password",length = 50)
    private String password;

    @Column(name = "email",length = 50)
    private String email;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> issuees;


}
