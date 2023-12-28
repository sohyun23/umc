package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.requestReview request, Member member, Store store) {



        return Review.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();
    }

    public static ReviewResponseDTO.review toReviewResponseDTO(Review review) {
        return ReviewResponseDTO.review.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
