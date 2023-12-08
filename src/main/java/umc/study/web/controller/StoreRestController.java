package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.converter.StoreConverter;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.service.MissionCommandServiceImpl;
import umc.study.service.StoreCommandServiceImpl;
import umc.study.web.dto.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandServiceImpl storeService;
    private final MissionCommandServiceImpl missionService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.storeResult> addStore(@RequestBody @Valid StoreRequestDTO.store request){
        Store store = storeService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toStoreResponseDTO(store));
    }


    @PostMapping("/{store_id}/reviews")
    public ApiResponse<ReviewResponseDTO.review> addReview(@RequestBody @Valid ReviewRequestDTO.review request,
                                                           @PathVariable("store_id") Long id){
        Review review = storeService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResponseDTO(review));
    }

    @PostMapping("/{store_id}/missions")
    public ApiResponse<MissionResponseDTO.mission> addMission(@RequestBody @Valid MissionRequestDTO.mission request,
                                                              @PathVariable String store_id){
        Mission mission = missionService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toMissionResponseDTO(mission));
    }
}
