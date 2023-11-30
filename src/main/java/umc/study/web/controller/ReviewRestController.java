package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {

    private final ReviewService reviewService;

    @PostMapping("/add")
    public ApiResponse<ReviewResponseDTO.review> add(@RequestBody @Validated ReviewRequestDTO.review request){
        Review review = reviewService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResponseDTO(review));
    }
}
