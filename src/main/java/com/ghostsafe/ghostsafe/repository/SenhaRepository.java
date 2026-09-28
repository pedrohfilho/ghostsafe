package com.ghostsafe.ghostsafe.repository;

import com.ghostsafe.ghostsafe.model.Senha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SenhaRepository extends JpaRepository<Senha, Integer> {
}
