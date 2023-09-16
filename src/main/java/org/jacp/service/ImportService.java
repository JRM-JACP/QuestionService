package org.jacp.service;

import lombok.AllArgsConstructor;
import org.jacp.entity.ImportEntity;
import org.jacp.repository.ImportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author saffchen created on 06.09.2023
 */
@Service
@AllArgsConstructor
public class ImportService {

    private final ImportRepository repository;

    public List<ImportEntity> getAll() {
        return repository.findAll();
    }
}
