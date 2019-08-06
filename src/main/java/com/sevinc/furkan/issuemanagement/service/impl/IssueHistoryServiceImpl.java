package com.sevinc.furkan.issuemanagement.service.impl;

import com.sevinc.furkan.issuemanagement.entity.IssueHistory;
import com.sevinc.furkan.issuemanagement.repository.IssueHistoryRepository;
import com.sevinc.furkan.issuemanagement.service.IssueHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository){
        this.issueHistoryRepository=issueHistoryRepository;
    }
    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if(issueHistory.getDate()== null){
            try {
                throw new IllegalAccessException("Issue History Date Cannot be Null");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return issueHistoryRepository.save(issueHistory);
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
