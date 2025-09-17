package org.example.backend.domain.company.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.domain.company.entity.Company;

@NoArgsConstructor
@Getter
@Setter
public class CompanySaveRequestDto {
    private String companyName;
    private String logoUrl;
    private String backgroundUrl;
    private String description;

    public Company toEntity() {
        return Company.builder()
                .companyName(companyName)
                .logoUrl(logoUrl)
                .backgroundUrl(backgroundUrl)
                .description(description)
                .build();
    }
}
