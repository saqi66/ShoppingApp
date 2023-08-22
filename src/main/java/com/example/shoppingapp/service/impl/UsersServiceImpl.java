package com.example.shoppingapp.service.impl;

import com.example.shoppingapp.dto.UsersDto;
import com.example.shoppingapp.dto.request.UsersRequest;
import com.example.shoppingapp.model.Users;
import com.example.shoppingapp.repository.UsersRepository;
import com.example.shoppingapp.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public UsersDto getUsersById(Long id) {
        Users users = usersRepository.getUsersById(id);
        return UsersDto.builder()
                .username(users.getUsername())
                .firstName(users.getFirstName())
                .lastName(users.getLastName())
                .address(users.getAddress())
                .telephone(users.getTelephone())
                .createdAt((Date) users.getCreatedAt())
                .modifiedAt((Date) users.getModifiedAt())
                .build();
    }

    @Override
    public void saveUsers(UsersRequest usersRequest) {
        Users users = Users.builder()
                .username(usersRequest.getUsername())
                .firstName(usersRequest.getFirstName())
                .lastName(usersRequest.getLastName())
                .address(usersRequest.getAddress())
                .password(usersRequest.getPassword())
                .telephone(usersRequest.getTelephone())
                .createdAt((Date) usersRequest.getCreatedAt())
                .build();

        usersRepository.save(users);
    }

    @Override
    public void updateUsers(UsersRequest usersRequest) {
        Users users = Users.builder()
                .id(usersRequest.getId())
                .username(usersRequest.getUsername())
                .firstName(usersRequest.getFirstName())
                .lastName(usersRequest.getLastName())
                .address(usersRequest.getAddress())
                .password(usersRequest.getPassword())
                .telephone(usersRequest.getTelephone())
                .modifiedAt(usersRequest.getModifiedAt())
                .build();

        usersRepository.save(users);
    }

    @Override
    public List<UsersDto> getAll() {
        List<Users> users = usersRepository.findAll();
        List<UsersDto> usersDtos = new ArrayList<>();

        for (Users user : users) {
            UsersDto usersDto = UsersDto.builder()
                    .username(user.getUsername())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .address(user.getAddress())
                    .telephone(user.getTelephone())
                    .createdAt(user.getCreatedAt())
                    .modifiedAt(user.getModifiedAt())
                    .build();

            usersDtos.add(usersDto);
        }
        return usersDtos;
    }


    @Override
    public void deleteById(Long id) {
        Users users = usersRepository.getUsersById(id);
        if (users == (null)) {
            throw new RuntimeException("bele id yoxdur");

        } else {
            usersRepository.deleteById(id);
        }
    }
}