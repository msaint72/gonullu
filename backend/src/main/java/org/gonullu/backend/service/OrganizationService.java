package org.gonullu.backend.service;

import org.gonullu.backend.ws.shared.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto getOrganizationById(long id);
    OrganizationDto updateOrganization(Long id,OrganizationDto organizationDto);
}
