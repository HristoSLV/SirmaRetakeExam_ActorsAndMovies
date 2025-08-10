package com.sirmascademy.SirmaRetakeExam.service;

import com.sirmascademy.SirmaRetakeExam.dto.RoleResponseDto;
import com.sirmascademy.SirmaRetakeExam.repository.RoleRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleResponseDto createRole(@Valid RoleResponseDto roleResponseDto) {
    }

    public List<RoleResponseDto> getAllRoles() {
    }

    public RoleResponseDto getRoleById(Long id) {
    }

    public RoleResponseDto deleteRole(Long id) {
    }

    public RoleResponseDto updateRole(@Valid Long id, RoleResponseDto roleResponseDto) {
    }
}
