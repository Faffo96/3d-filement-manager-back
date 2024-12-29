package com._dFilamentManager._dFilamentManager.repository;

import com._dFilamentManager._dFilamentManager.entity.Filament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilamentRepository extends JpaRepository<Filament, Long> {
    public Optional<Filament> findById(Long id);
    public boolean existsById(Long id);
    public Optional<Filament> findByName(String name);
}

