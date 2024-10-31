package com.syncnews.newsms.service.role.mapper;

import com.syncnews.newsms.entity.RoleEntity;
import com.syncnews.newsms.service.role.dto.RoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto mappingRoleDtoBy(final RoleEntity roleEntity);
}
