package com.sevinc.furkan.issuemanagement.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Column(name = "crated_at")
    private Date createdAt;
    @Column(name = "created_by", length = 100)
    private String createdBy;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(name = "update_by", length = 100)
    private String updatedBy;
    @Column(name = "status")
    private Boolean status;


}
