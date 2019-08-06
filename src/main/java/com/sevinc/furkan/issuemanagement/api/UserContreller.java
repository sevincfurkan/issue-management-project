package com.sevinc.furkan.issuemanagement.api;

import com.sevinc.furkan.issuemanagement.service.impl.UserServiceImpl;
import com.sevinc.furkan.issuemanagement.util.ApiPaths;
import com.sevinc.furkan.issuemanagement.Dto.UserDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(ApiPaths.UserCtrl.CTRL)
public class UserContreller {

    private final UserServiceImpl userServiceImpl;

    public UserContreller(UserServiceImpl userServiceImpl){
        this.userServiceImpl=userServiceImpl;
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation",response = UserDto.class)
    public ResponseEntity<UserDto> getById(@PathVariable(value = "id",required = true) Long id){
        UserDto userDto=userServiceImpl.getById(id);
        return ResponseEntity.ok(userDto);
    }

}
