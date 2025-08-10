package com.sirmascademy.SirmaRetakeExam.service;

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

    public RoleResponseDto createRole(RoleResponseDto roleResponseDto) {
        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setActorId(roleResponseDto.getActorId());
        roleEntity.setMovieId(roleResponseDto.getMovieId());

        if (roleResponseDto.getRoleName() != null) {
            roleEntity.setRoleName(roleResponseDto.getRoleName());
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

    public RoleResponseDto updateRole(Long id, RoleResponseDto roleResponseDto) {
        RoleEntity roleEntity = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(id));

        roleEntity.setActorId(roleResponseDto.getActorId());
        roleEntity.setMovieId(roleResponseDto.getMovieId());

        if (roleResponseDto.getRoleName() != null) {
            roleEntity.setRoleName(roleResponseDto.getRoleName());
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
