package org.example.backend.domain.company.dto;

import lombok.Getter;
import org.example.backend.domain.company.entity.Company;

@Getter
public class CompanyResponseDto {
    private final Long companyId;
    private final String companyName;
    private final String logoUrl;
    private final String backgroundUrl;
    private final String description;

    public CompanyResponseDto(Company entity) {
        this.companyId = entity.getCompanyId();
        this.companyName = entity.getCompanyName();
        this.logoUrl = entity.getLogoUrl();
        this.backgroundUrl = entity.getBackgroundUrl();
        this.description = entity.getDescription();
    }
}
