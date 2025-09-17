package org.example.backend.domain.question.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.backend.domain.common.entity.BaseEntity;
import org.example.backend.domain.company.entity.Company;
import org.example.backend.domain.job.entity.Job;
import org.example.backend.domain.user_erd.entity.User;

@Table(name = "question")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Question extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;

    @Builder
    public Question(String content, int year, User user, Company company, Job job) {
        this.content = content;
        this.year = year;
        this.user = user;
        this.company = company;
        this.job = job;
    }
}
