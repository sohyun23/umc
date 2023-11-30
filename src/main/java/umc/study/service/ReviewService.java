package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.repository.ReviewRepository;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;
    public Review addReview(ReviewRequestDTO.review request) {
        Review review = ReviewConverter.toReview(request);
        return reviewRepository.save(review);

    }
}
