package com.sirmascademy.SirmaRetakeExam.service;

import com.sirmascademy.SirmaRetakeExam.dto.RoleRequestDto;
import com.sirmascademy.SirmaRetakeExam.dto.RoleResponseDto;
import com.sirmascademy.SirmaRetakeExam.exception.RoleNotFoundException;
import com.sirmascademy.SirmaRetakeExam.mapper.RoleMapper;
import com.sirmascademy.SirmaRetakeExam.model.RoleEntity;
import com.sirmascademy.SirmaRetakeExam.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleResponseDto createRole(RoleRequestDto roleRequestDto) {
        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setActorId(roleRequestDto.getActorId());
        roleEntity.setMovieId(roleRequestDto.getMovieId());

        if (roleRequestDto.getRoleName().equalsIgnoreCase("null")) {
        } else {
            roleEntity.setRoleName(roleRequestDto.getRoleName());
        }

        roleRepository.save(roleEntity);

        return RoleMapper.toRoleDto(roleEntity);
    }

    public List<RoleResponseDto> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(RoleMapper::toRoleDto)
                .toList();
    }

    public RoleResponseDto getRoleById(Long id) {
        RoleEntity roleEntity = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(id));

        return RoleMapper.toRoleDto(roleEntity);
    }

    public RoleResponseDto updateRole(Long id, RoleRequestDto roleRequestDto) {
        RoleEntity roleEntity = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(id));

        roleEntity.setActorId(roleRequestDto.getActorId());
        roleEntity.setMovieId(roleRequestDto.getMovieId());

        if (roleRequestDto.getRoleName() != null) {
            roleEntity.setRoleName(roleRequestDto.getRoleName());
        }

        roleRepository.save(roleEntity);

        return RoleMapper.toRoleDto(roleEntity);
    }

    public RoleResponseDto deleteRole(Long id) {
        RoleEntity roleEntity = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(id));

        roleRepository.delete(roleEntity);

        return RoleMapper.toRoleDto(roleEntity);
    }

}
