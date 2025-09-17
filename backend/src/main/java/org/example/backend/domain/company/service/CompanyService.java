package org.example.backend.domain.company.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.company.dto.CompanyListResponseDto;
import org.example.backend.domain.company.dto.CompanyResponseDto;
import org.example.backend.domain.company.dto.CompanySaveRequestDto;
import org.example.backend.domain.company.dto.CompanyUpdateRequestDto;
import org.example.backend.domain.company.entity.Company;
import org.example.backend.domain.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Transactional
    public Long saveCompany(CompanySaveRequestDto requestDto) {
        return companyRepository.save(requestDto.toEntity()).getCompanyId();
    }

    @Transactional
    public Long updateCompany(Long id, CompanyUpdateRequestDto requestDto) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회사가 없습니다. id=" + id));

        company.update(requestDto.getCompanyName(), requestDto.getLogoUrl(), requestDto.getBackgroundUrl(), requestDto.getDescription());
        return id;
    }

    @Transactional
    public void deleteCompany(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회사가 없습니다. id=" + id));
        companyRepository.delete(company);
    }

    @Transactional(readOnly = true)
    public CompanyResponseDto findCompanyById(Long id) {
        Company entity = companyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회사가 없습니다. id=" + id));
        return new CompanyResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<CompanyListResponseDto> findAllCompanies() {
        return companyRepository.findAll().stream()
                .map(CompanyListResponseDto::new)
                .collect(Collectors.toList());
    }
}
