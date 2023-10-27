package org.jacp.service;

import lombok.AllArgsConstructor;
import org.jacp.entity.ImportEntity;
import org.jacp.entity.TestImportEntity;
import org.jacp.repository.ImportRepository;
import org.jacp.repository.TestImportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author saffchen created on 06.09.2023
 */
@Service
@AllArgsConstructor
public class ImportService {

    private final ImportRepository repository;
    private final TestImportRepository testImportRepository;

    public List<ImportEntity> getAllImports() {
        return repository.findAll();
    }

    public List<TestImportEntity> getAllTestImports() {
        return testImportRepository.findAll();
    }
}
