package com.syncnews.newsms.service.role;

import com.syncnews.newsms.entity.RoleEntity;
import com.syncnews.newsms.repository.role.RoleRepository;
import com.syncnews.newsms.service.role.dto.RoleDto;
import com.syncnews.newsms.service.role.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository repository;
    private final RoleMapper mapper;

    public RoleDto getRoleByName(String name) {
        final RoleEntity roleEntity = repository.findByName(name);

        return mapper.mappingRoleDtoBy(roleEntity);
    }
}
