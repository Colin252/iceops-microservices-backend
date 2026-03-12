package com.iceops.iceops_organization_service.service;

import com.iceops.iceops_organization_service.entity.OrganizationEntity;
import com.iceops.iceops_organization_service.repository.OrganizationRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Optional<OrganizationEntity> getOrganizationById(Long id) {
        return organizationRepository.findById(id);
    }

}