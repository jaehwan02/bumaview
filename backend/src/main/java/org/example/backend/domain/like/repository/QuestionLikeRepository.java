package org.example.backend.domain.like.repository;

import org.example.backend.domain.like.entity.QuestionLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionLikeRepository extends JpaRepository<QuestionLike, Long> {
}
