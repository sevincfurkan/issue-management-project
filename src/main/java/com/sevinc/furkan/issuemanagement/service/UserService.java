package com.sevinc.furkan.issuemanagement.service;

import com.sevinc.furkan.issuemanagement.entity.User;
import com.sevinc.furkan.issuemanagement.Dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user);
    UserDto getById(Long id);
    Page<User> getAllPageable(Pageable pageable);
    User getByUserName(String userName);

    UserDto getByUsername(String username);
}
