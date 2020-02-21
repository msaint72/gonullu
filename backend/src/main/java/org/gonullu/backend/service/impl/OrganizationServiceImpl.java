package org.gonullu.backend.service.impl;

import org.gonullu.backend.domain.Organization;
import org.gonullu.backend.exception.NotFoundException;
import org.gonullu.backend.exception.OrganizationNotFoundException;
import org.gonullu.backend.repository.OrganizationRepository;
import org.gonullu.backend.service.OrganizationService;
import org.gonullu.backend.ws.shared.dto.OrganizationDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto getOrganizationById(long id) {
        Optional<Organization> organization=organizationRepository.findById(id);
        if(!organization.isPresent()) throw new OrganizationNotFoundException("Organization not found:"+id);
        OrganizationDto returnValue=new OrganizationDto();
        BeanUtils.copyProperties(organization.get(),returnValue);
        return returnValue;
    }

    @Override
    public OrganizationDto updateOrganization(Long id,OrganizationDto organizationDto){
        Optional<Organization> organization=organizationRepository.findById(id);
        if(!organization.isPresent()) throw new OrganizationNotFoundException("Organization not found:"+id);
        organization.get().setName(organizationDto.getName());
        organization.get().setSummary(organizationDto.getSummary());
        Organization updatedOrganization=organizationRepository.save(organization.get());

        OrganizationDto returnValue=new OrganizationDto();
        BeanUtils.copyProperties(updatedOrganization,returnValue);
        return returnValue;
    }
}
