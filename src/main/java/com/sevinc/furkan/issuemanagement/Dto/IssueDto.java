package com.sevinc.furkan.issuemanagement.Dto;

import com.sevinc.furkan.issuemanagement.entity.IssueStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Issue Data Transfer Object")
public class IssueDto {
    @ApiModelProperty(value = "Issue ID")
    private Long id;
    @ApiModelProperty(value = "Issue Description")
    private String description;
    @ApiModelProperty(value = "Issue Detail")
    private String details;
    @ApiModelProperty(value = "Issue Date")
    private Date date;
    @ApiModelProperty(value = "Issue Issue Status")
    private IssueStatus issueStatus;
    private UserDto assignee;
    private ProjectDto project;
}
