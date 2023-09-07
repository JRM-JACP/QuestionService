package org.jacp.service;

import lombok.AllArgsConstructor;
import org.jacp.entity.ImportEntity;
import org.jacp.repository.ImportRepository;
import org.springframework.stereotype.Service;

/**
 * @author saffchen created on 06.09.2023
 */
@Service
@AllArgsConstructor
public class ImportService {

    ImportRepository repository;

    public ImportEntity getAll() {
        return repository.getAll();
    }
}
