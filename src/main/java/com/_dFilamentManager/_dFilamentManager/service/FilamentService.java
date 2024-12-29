package com._dFilamentManager._dFilamentManager.service;

import com._dFilamentManager._dFilamentManager.entity.Filament;
import com._dFilamentManager._dFilamentManager.repository.FilamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilamentService {

    @Autowired
    private FilamentRepository filamentRepository;

    public List<Filament> getAll() {
        return filamentRepository.findAll();
    }

    public Page<Filament> getAllPaged(int page, int size) {
        return filamentRepository.findAll(PageRequest.of(page, size));
    }

    public Filament getById(Long id) {
        return filamentRepository.findById(id).orElseThrow(() -> new RuntimeException("Filament not found"));
    }

    public Filament getByName(String name) {
        return filamentRepository.findByName(name).orElseThrow(() -> new RuntimeException("Filament not found"));
    }

    public Filament save(Filament filament) {
        return filamentRepository.save(filament);
    }

    public Filament update(Long id, Filament updatedFilament) {
        Filament existingFilament = filamentRepository.findById(id).orElseThrow(() -> new RuntimeException("Filament not found"));
        existingFilament.setName(updatedFilament.getName());
        existingFilament.setGrams(updatedFilament.getGrams());
        existingFilament.setPrice(updatedFilament.getPrice());
        existingFilament.setMaterial(updatedFilament.getMaterial());
        existingFilament.setColor(updatedFilament.getColor());
        existingFilament.setImg(updatedFilament.getImg());
        return filamentRepository.save(existingFilament);
    }

    public void delete(Long id) {
        if (filamentRepository.existsById(id)) {
            filamentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Filament not found");
        }
    }
}