package org.example.backend.domain.community.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.backend.domain.common.entity.BaseEntity;
import org.example.backend.domain.user_erd.entity.User;

@Table(name = "community_post")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class CommunityPost extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private boolean moderated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public CommunityPost(String content, boolean moderated, User user) {
        this.content = content;
        this.moderated = moderated;
        this.user = user;
    }
}
