package com.sevinc.furkan.issuemanagement.service;

import com.sevinc.furkan.issuemanagement.util.TPage;
import com.sevinc.furkan.issuemanagement.Dto.IssueDto;
import org.springframework.data.domain.Pageable;

public interface IssueService {
    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(Long id);

    IssueDto update(Long id, IssueDto issue);
}
