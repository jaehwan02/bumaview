package org.example.backend.domain.company.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CompanyUpdateRequestDto {
    private String companyName;
    private String logoUrl;
    private String backgroundUrl;
    private String description;
}
