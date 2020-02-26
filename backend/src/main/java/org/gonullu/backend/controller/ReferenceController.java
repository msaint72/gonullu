package org.gonullu.backend.controller;

import org.gonullu.backend.domain.Cause;
import org.gonullu.backend.service.ReferenceValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/reference")public class ReferenceController {
    @Autowired
    ReferenceValuesService referenceValuesService;

    @GetMapping(path="/cause")
    public List<Cause> getCauseList() throws Exception {
        return referenceValuesService.getAllCauses();
    }
}
