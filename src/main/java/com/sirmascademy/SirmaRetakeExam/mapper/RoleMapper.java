package com.sirmascademy.SirmaRetakeExam.mapper;

import com.sirmascademy.SirmaRetakeExam.dto.RoleResponseDto;
import com.sirmascademy.SirmaRetakeExam.model.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public static RoleResponseDto toRoleDto(RoleEntity role) {
        RoleResponseDto roleResponseDto = new RoleResponseDto();

        roleResponseDto.setId(role.getId());
        roleResponseDto.setActorId(role.getActorId());
        roleResponseDto.setMovieId(role.getMovieId());

        if (role.getRoleName() != null){
            roleResponseDto.setRoleName(role.getRoleName());
        }

        return roleResponseDto;
    }

}
