package org.gonullu.backend.service.impl;

import org.gonullu.backend.domain.Cause;
import org.gonullu.backend.repository.CauseRepository;
import org.gonullu.backend.service.ReferenceValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenceValuesServiceImpl implements ReferenceValuesService {
    @Autowired
    CauseRepository causeRepository;
    @Override
    public List<Cause> getAllCauses() {
        return causeRepository.findAll();
    }
}
