package com.acme.shop.user;

import com.acme.shop.user.dto.UpdateUserRequest;
import com.acme.shop.user.dto.UserResponse;
import org.springframework.stereotype.Component;
import com.acme.shop.user.dto.CreateUserRequest;
@Component
public class UserMapper {

    public User toEntity(CreateUserRequest request, String passwordHash) {
        User user = new User();
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setEmail(request.email());
        user.setPhoneNumber(request.phoneNumber());
        user.setPasswordHash(passwordHash);
        user.setAddress(request.address());
        return user;
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAddress());
    }
    public void updateEntity(User user, UpdateUserRequest request) {
        if (user.getId() != null) {
            user.setFirstName(request.firstName());
        }
        if(user.getEmail() != null) {
            user.setEmail(request.email());
        }
    }
}