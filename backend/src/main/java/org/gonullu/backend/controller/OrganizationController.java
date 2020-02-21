package org.gonullu.backend.controller;

import org.gonullu.backend.service.OrganizationService;
import org.gonullu.backend.ws.model.request.OrganizationDetailsRequestModel;
import org.gonullu.backend.ws.model.response.OrganizationRest;
import org.gonullu.backend.ws.shared.dto.OrganizationDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/organization")
public class OrganizationController {
    @Autowired
    OrganizationService organizationService;

    @GetMapping(path="/{id}")
    public OrganizationRest getOrganization(@PathVariable long id) throws Exception {
        OrganizationRest returnValue = new OrganizationRest();

        OrganizationDto organizationDto=organizationService.getOrganizationById(id);
        BeanUtils.copyProperties(organizationDto,returnValue);
        return returnValue;
    }
    @PutMapping(path="/{organizationId}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public OrganizationRest updateOrganization(@PathVariable Long organizationId,@RequestBody OrganizationDetailsRequestModel organizationDetails) throws Exception {
        OrganizationRest returnValue = new OrganizationRest();

        OrganizationDto organizationDto=new OrganizationDto();
        BeanUtils.copyProperties(organizationDetails,organizationDto);
        organizationService.updateOrganization(organizationId,organizationDto);
        BeanUtils.copyProperties(organizationDto,returnValue);
        return returnValue;
    }
}
