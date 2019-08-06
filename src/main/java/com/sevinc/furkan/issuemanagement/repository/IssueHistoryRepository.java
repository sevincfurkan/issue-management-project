package com.sevinc.furkan.issuemanagement.repository;

import com.sevinc.furkan.issuemanagement.entity.IssueHistory;

import org.springframework.data.jpa.repository.JpaRepository;



public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {
    //Page<IssueHistory> findAll(Pageable pageable);
}
