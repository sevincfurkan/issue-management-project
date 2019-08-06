package com.sevinc.furkan.issuemanagement.service.impl;

import com.sevinc.furkan.issuemanagement.entity.Project;
import com.sevinc.furkan.issuemanagement.repository.ProjectRepository;
import com.sevinc.furkan.issuemanagement.service.ProjectService;
import com.sevinc.furkan.issuemanagement.util.TPage;
import com.sevinc.furkan.issuemanagement.Dto.ProjectDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {
        Project projectCheck = projectRepository.findByProjectCode(project.getProjectCode());
        if (projectCheck != null) {
            throw new IllegalArgumentException("Project Code Already Exist");
        }

        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }


    @Override
    public ProjectDto getById(Long id) {
        Project project = projectRepository.getOne(id);
        return modelMapper.map(project, ProjectDto.class);
    }


    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return response;
    }

    @Override
    public Boolean delete(ProjectDto project) {
        try {
            Project projectDb = modelMapper.map(project, Project.class);
            projectRepository.delete(projectDb);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Project getByProjectCode(String projectCode) {
        return null;
    }

    public Boolean delete(Long id){
        try {
            Project project = projectRepository.getOne(id);
            projectRepository.delete(project);
            return true;
        } catch (Exception e) {

            return false;
        }
    }


    @Override
    public List<Project> getByProjectCodeContains(Project project) {
        return null;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectDb = projectRepository.getOne(id);
        if (projectDb == null) {
            throw new IllegalArgumentException("Project Does Not Exist ID:" + id);
        }
        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(),id);
        if (projectCheck != null && projectCheck.getId() != projectDb.getId()) {
            throw new IllegalArgumentException("Project Code Already Exist");
        }

        projectDb.setProjectName(project.getProjectName());
        projectDb.setProjectCode(project.getProjectCode());
        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class); // dto to model convert
    }
}
