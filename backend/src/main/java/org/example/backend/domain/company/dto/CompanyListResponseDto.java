package org.example.backend.domain.company.dto;

import lombok.Getter;
import org.example.backend.domain.company.entity.Company;

@Getter
public class CompanyListResponseDto {
    private final Long companyId;
    private final String companyName;
    private final String logoUrl;

    public CompanyListResponseDto(Company entity) {
        this.companyId = entity.getCompanyId();
        this.companyName = entity.getCompanyName();
        this.logoUrl = entity.getLogoUrl();
    }
}
