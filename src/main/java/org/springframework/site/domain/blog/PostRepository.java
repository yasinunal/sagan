package org.springframework.site.domain.blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.site.domain.team.MemberProfile;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	Page<Post> findByCategoryAndDraftFalse(PostCategory category, Pageable pageable);

	Page<Post> findByDraftTrue(Pageable pageRequest);

	Page<Post> findByDraftFalseAndPublishAtBefore(Date publishedBefore, Pageable pageRequest);

	List<Post> findByDraftFalseAndPublishAtBefore(Date publishedBefore);

	Page<Post> findByCategoryAndDraftFalseAndPublishAtBefore(PostCategory category, Date publishedBefore, Pageable pageRequest);

	Page<Post> findByBroadcastAndDraftFalseAndPublishAtBefore(boolean broadcast, Date publishedBefore, Pageable pageRequest);

	Page<Post> findByDraftFalseAndPublishAtAfter(Date now, Pageable pageRequest);

	Page<Post> findByDraftFalseAndAuthorAndPublishAtBefore(MemberProfile profile, Date publishedBefore, Pageable pageRequest);

	Post findByTitle(String title);

	Post findByTitleAndCreatedAt(String title, Date createdAt);

	Post findByPublicSlugAndDraftFalseAndPublishAtBefore(String publicSlug, Date now);
}
