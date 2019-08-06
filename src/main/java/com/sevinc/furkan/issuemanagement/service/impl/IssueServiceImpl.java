package com.sevinc.furkan.issuemanagement.service.impl;

import com.sevinc.furkan.issuemanagement.repository.IssueRepository;
import com.sevinc.furkan.issuemanagement.service.IssueService;
import com.sevinc.furkan.issuemanagement.util.TPage;
import com.sevinc.furkan.issuemanagement.Dto.IssueDto;
import com.sevinc.furkan.issuemanagement.entity.Issue;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issueDto) {

        Issue issue = modelMapper.map(issueDto, Issue.class);
        issue = issueRepository.save(issue);
        return modelMapper.map(issue, IssueDto.class);

    }

    @Override
    public IssueDto getById(Long id) {
        Issue issue=issueRepository.getOne(id);
        return modelMapper.map(issue,IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(), IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }


    @Override
    public Boolean delete(Long id) {
        try {
            issueRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public IssueDto update(Long id, IssueDto issue) {
        Issue issueDb = issueRepository.getOne(id);

        issueDb.setDate(issue.getDate());
        issueDb.setDescription(issue.getDescription());
        issueDb.setDetails(issue.getDetails());
        issueDb.setIssueStatus(issue.getIssueStatus());
        issueDb = issueRepository.save(issueDb);
        return modelMapper.map(issueDb, IssueDto.class);
    }
}
