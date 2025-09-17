package org.example.backend.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.backend.domain.company.dto.CompanySaveRequestDto;
import org.example.backend.domain.company.dto.CompanyUpdateRequestDto;
import org.example.backend.domain.company.entity.Company;
import org.example.backend.domain.company.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Company savedCompany;

    @BeforeEach
    void setUp() {
        companyRepository.deleteAll();
        Company company = Company.builder()
                .companyName("Test Company")
                .logoUrl("http://logo.url")
                .backgroundUrl("http://background.url")
                .description("A company for testing.")
                .build();
        savedCompany = companyRepository.save(company);
    }

    @Test
    @DisplayName("회사 등록 API 테스트")
    void saveCompany() throws Exception {
        // given
        CompanySaveRequestDto requestDto = new CompanySaveRequestDto();
        requestDto.setCompanyName("New Company");
        requestDto.setLogoUrl("new_logo.png");
        requestDto.setBackgroundUrl("new_bg.png");
        requestDto.setDescription("New description");

        // when & then
        mockMvc.perform(post("/api/companies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        List<Company> all = companyRepository.findAll();
        assertThat(all).hasSize(2);
        assertThat(all.get(1).getCompanyName()).isEqualTo("New Company");
    }

    @Test
    @DisplayName("회사 전체 조회 API 테스트")
    void findAllCompanies() throws Exception {
        // when & then
        mockMvc.perform(get("/api/companies"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].companyName").value("Test Company"));
    }

    @Test
    @DisplayName("회사 단일 조회 API 테스트")
    void findCompanyById() throws Exception {
        // when & then
        mockMvc.perform(get("/api/companies/" + savedCompany.getCompanyId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.companyName").value("Test Company"));
    }

    @Test
    @DisplayName("회사 수정 API 테스트")
    void updateCompany() throws Exception {
        // given
        CompanyUpdateRequestDto requestDto = new CompanyUpdateRequestDto();
        requestDto.setCompanyName("Updated Company");
        requestDto.setLogoUrl("updated_logo.png");
        requestDto.setBackgroundUrl("updated_bg.png");
        requestDto.setDescription("Updated description");


        // when & then
        mockMvc.perform(put("/api/companies/" + savedCompany.getCompanyId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        Company updatedCompany = companyRepository.findById(savedCompany.getCompanyId()).orElseThrow();
        assertThat(updatedCompany.getCompanyName()).isEqualTo("Updated Company");
    }

    @Test
    @DisplayName("회사 삭제 API 테스트")
    void deleteCompany() throws Exception {
        // when & then
        mockMvc.perform(delete("/api/companies/" + savedCompany.getCompanyId()))
                .andExpect(status().isOk());

        assertThat(companyRepository.findById(savedCompany.getCompanyId())).isEmpty();
    }
}
