package com.syncnews.newsms.service.user;

import com.syncnews.newsms.entity.UserEntity;
import com.syncnews.newsms.repository.user.UserRepository;
import com.syncnews.newsms.service.user.dto.UserCreateDto;
import com.syncnews.newsms.service.user.dto.UserDto;
import com.syncnews.newsms.service.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserDto getUserByUsername(final String username) {
        Optional<UserEntity> userEntity = repository.findByUsername(username);

        return userEntity.map(mapper::mappingUserDtoBy).orElse(null);
    }

    public UserDto createUser(final UserCreateDto userCreateDto) {
        UserEntity userEntity = mapper.mappingUserEntityBy(userCreateDto);

        UserEntity userSaved = repository.save(userEntity);

        return mapper.mappingUserDtoBy(userSaved);
    }
}
