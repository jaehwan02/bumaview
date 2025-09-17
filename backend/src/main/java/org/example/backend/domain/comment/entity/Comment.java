package org.example.backend.domain.comment.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.backend.domain.common.entity.BaseEntity;
import org.example.backend.domain.community.entity.CommunityPost;
import org.example.backend.domain.question.entity.Question;
import org.example.backend.domain.user_erd.entity.User;

@Table(name = "comment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private CommunityPost communityPost;

    @Builder
    public Comment(String content, User user, Question question, CommunityPost communityPost) {
        this.content = content;
        this.user = user;
        this.question = question;
        this.communityPost = communityPost;
    }
}
