package umc.study.converter;

import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.review request) {
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .build();
    }

    public static ReviewResponseDTO.review toReviewResponseDTO(Review review) {
        return ReviewResponseDTO.review.builder()
                .reviewId(review.getId())
                .title(review.getTitle())
                .score(review.getScore())
                .build();
    }
}
