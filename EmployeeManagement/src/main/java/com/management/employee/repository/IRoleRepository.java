package com.management.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.employee.entity.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

}