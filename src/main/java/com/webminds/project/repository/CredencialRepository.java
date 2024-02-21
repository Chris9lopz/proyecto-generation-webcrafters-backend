package com.webminds.project.repository;

import com.webminds.project.entities.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredencialRepository extends JpaRepository<Credencial, Integer> {
}
