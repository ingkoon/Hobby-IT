package com.a505.hobbyit.hobbyarticle.domain;

import com.a505.hobbyit.hobbyarticle.enums.HobbyArticleCategory;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class HobbyArticleQRepositoryImpl implements HobbyArticleQRepository{

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    QHobbyArticle hobbyArticle = QHobbyArticle.hobbyArticle;

    @Override
    public Slice<HobbyArticle> findHobbyArticle(Long storedId, Long hobbyId, Pageable pageable) {
        List<HobbyArticle> result = queryFactory
                .selectFrom(hobbyArticle)
                .where(
                        //no-offset 페이징 처리
                    ltStoreId(storedId),
                    // 카테고리가 일반 게시글일 경우
                    hobbyArticle.category.eq(HobbyArticleCategory.GENERAL)
                ).orderBy(hobbyArticle.id.desc())
                .limit(pageable.getPageSize()+1)
                .fetch();
        return checkLastPage(pageable, result);
    }

    // no-offset 방식 처리하는 메서드
    private BooleanExpression ltStoreId(Long storeId) {
        if (storeId == null) {
            return null;
        }

        return hobbyArticle.id.lt(storeId);
    }

    // 무한 스크롤 방식 처리하는 메서드
    private Slice<HobbyArticle> checkLastPage(Pageable pageable, List<HobbyArticle> results) {

        boolean hasNext = false;

        // 조회한 결과 개수가 요청한 페이지 사이즈보다 크면 뒤에 더 있음, next = true
        if (results.size() > pageable.getPageSize()) {
            hasNext = true;
            results.remove(pageable.getPageSize());
        }

        return new SliceImpl<>(results, pageable, hasNext);
    }
}
