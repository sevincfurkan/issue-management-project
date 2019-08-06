package com.sevinc.furkan.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "issue") //tablonun adını belirtir
@Data //getter ve setter yaratır
@NoArgsConstructor // defualt constructor oluşturur
@AllArgsConstructor // bütün değişkenlerin olduğu consructor
@ToString // toString metodunu oluşturur
@EqualsAndHashCode(callSuper = false)
public class Issue extends BaseEntity{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO) //primary olduğunu belirtir
    private Long id;

    @Column(name = "description",length = 400)
    private String description;

    @Column(name="details",length = 4000)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issue_status")
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id") // farklı sınıftan olduğu için kullanıldı
    @ManyToOne(optional = true,fetch = FetchType.LAZY) //fetch lazy ihtiyaç duyulduğu zaman
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Project project;



}