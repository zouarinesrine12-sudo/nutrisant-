package com.acme.shop.user;

import com.acme.shop.shared.exception.Duplicateresourceexception;
import com.acme.shop.shared.exception.ResourceNotFoundException;
import com.acme.shop.user.dto.UpdateUserRequest;
import com.acme.shop.user.dto.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

import com.acme.shop.user.dto.CreateUserRequest;  //
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       UserMapper userMapper,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse create(CreateUserRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new Duplicateresourceexception("Email déjà utilisé : " + request.email());
        }
        String hash = passwordEncoder.encode(request.password());
        User saved = userRepository.save(userMapper.toEntity(request, hash));
        return userMapper.toResponse(saved);
    }

    public UserResponse getById(Long id) {
        return userMapper.toResponse(findOrThrow(id));
    }

    public List<UserResponse> list() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponse)
                .toList();
    }

    public UserResponse update(Long id, UpdateUserRequest request) {
        User user = findOrThrow(id);
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setPhoneNumber(request.phoneNumber());
        user.setAddress(request.address());
        return userMapper.toResponse(userRepository.save(user));
    }

    public void delete(Long id) {
        userRepository.delete(findOrThrow(id));
    }

    private User findOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User introuvable : " + id));
    }
}