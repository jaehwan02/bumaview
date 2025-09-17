package org.example.backend.domain.company.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "company")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "logo_url", columnDefinition = "TEXT")
    private String logoUrl;

    @Column(name = "background_url", columnDefinition = "TEXT")
    private String backgroundUrl;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Builder
    public Company(String companyName, String logoUrl, String backgroundUrl, String description) {
        this.companyName = companyName;
        this.logoUrl = logoUrl;
        this.backgroundUrl = backgroundUrl;
        this.description = description;
    }
}
