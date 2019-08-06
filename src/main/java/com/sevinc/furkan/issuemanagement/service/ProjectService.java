package com.sevinc.furkan.issuemanagement.service;

import com.sevinc.furkan.issuemanagement.entity.Project;
import com.sevinc.furkan.issuemanagement.util.TPage;
import com.sevinc.furkan.issuemanagement.Dto.ProjectDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete(ProjectDto project);

    Project getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(Project projectCode);

    ProjectDto update(Long id, ProjectDto project);

}
