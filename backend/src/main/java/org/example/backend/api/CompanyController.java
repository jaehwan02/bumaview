package org.example.backend.api;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.company.dto.CompanyListResponseDto;
import org.example.backend.domain.company.dto.CompanyResponseDto;
import org.example.backend.domain.company.dto.CompanySaveRequestDto;
import org.example.backend.domain.company.dto.CompanyUpdateRequestDto;
import org.example.backend.domain.company.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<Long> saveCompany(@RequestBody CompanySaveRequestDto requestDto) {
        return ResponseEntity.ok(companyService.saveCompany(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateCompany(@PathVariable Long id, @RequestBody CompanyUpdateRequestDto requestDto) {
        return ResponseEntity.ok(companyService.updateCompany(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponseDto> findCompanyById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.findCompanyById(id));
    }

    @GetMapping
    public ResponseEntity<List<CompanyListResponseDto>> findAllCompanies() {
        return ResponseEntity.ok(companyService.findAllCompanies());
    }
}
