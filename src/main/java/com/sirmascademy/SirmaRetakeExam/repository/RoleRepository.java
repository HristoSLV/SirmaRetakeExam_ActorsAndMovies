package com.sirmascademy.SirmaRetakeExam.repository;

import com.sirmascademy.SirmaRetakeExam.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
}
