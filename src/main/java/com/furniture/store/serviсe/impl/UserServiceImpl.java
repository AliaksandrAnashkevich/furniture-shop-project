package com.furniture.store.serviсe.impl;

import com.furniture.store.dto.request.UserRequest;
import com.furniture.store.dto.response.UserResponse;
import com.furniture.store.mapper.UserMapper;
import com.furniture.store.model.User;
import com.furniture.store.repository.UserRepository;
import com.furniture.store.serviсe.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow();

        return userMapper.entityToDto(user);
    }

    @Override
    public UserResponse findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow();

        return userMapper.entityToDto(user);
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = userMapper.dtoToEntity(userRequest);
        userRepository.save(user);
        return userMapper.entityToDto(user);
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        User oldUser = userRepository.findById(id)
                .orElseThrow();
        User user = userMapper.updateRequestToEntity(userRequest, oldUser);
        userRepository.save(user);
        return userMapper.entityToDto(user);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow();

        userRepository.delete(user);
    }
}