package com.sevinc.furkan.issuemanagement.repository;

import com.sevinc.furkan.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {
}
