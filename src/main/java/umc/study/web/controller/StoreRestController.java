package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.converter.StoreConverter;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.service.MissionCommandServiceImpl;
import umc.study.service.store.StoreCommandServiceImpl;
import umc.study.service.store.StoreQueryServiceImpl;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandServiceImpl storeService;
    private final StoreQueryServiceImpl storeQueryService;
    private final MissionCommandServiceImpl missionService;

    // Store 추가
    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.storeResult> addStore(@RequestBody @Valid StoreRequestDTO.store request) {
        Store store = storeService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toStoreResponseDTO(store));
    }


    // Review 추가
    @PostMapping("/{store_id}/reviews")
    public ApiResponse<ReviewResponseDTO.review> addReview(@RequestBody @Valid ReviewRequestDTO.requestReview request,
                                                           @PathVariable("store_id") Long id) {
        Review review = storeService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResponseDTO(review));
    }

    // Store에 Mission 추가
    @PostMapping("/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.mission> addMission(@RequestBody @Valid MissionRequestDTO.requestMission request,
                                                              @PathVariable Long storeId) {
        Mission mission = missionService.addMission(request);

        return ApiResponse.onSuccess(MissionConverter.toMissionResponseDTO(mission));
    }

    // Store에 challenging 상태 Mission 추가
    @PostMapping("/{store_id}/missions/{mission_status}")
    public ApiResponse<MissionResponseDTO.mission> addChellengingMission(@RequestBody @Valid MissionRequestDTO.challengingMission request,
                                                                         @PathVariable(name = "store_id") Long storeId
    ) {

        Mission mission = missionService.addChellengingMission(request);
        return ApiResponse.onSuccess(MissionConverter.toMissionResponseDTO(mission));
    }


    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/{storeId}/reviews")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId, @CheckPage @RequestParam(name = "page") Integer page){

        Page<Review> reviewList =  storeQueryService.getReviewList(storeId,page-1);

        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }

    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/{storeId}/missions")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getMissionList(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page){
        Page<Mission> missionList = storeQueryService.getMissionList(storeId,page);
        return ApiResponse.onSuccess(MissionConverter.missionPreViewListDTO(missionList));
    }

//    @Operation(summary = "진행중인 미션 진행 완료로 바꾸기 API",description = "진행중인 미션 진행 완료로 바꾸는 API입니다.")
//    @GetMapping("{missionId}/complete")
//    @ApiResponses({
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
//    })
//    @Parameters({
//            @Parameter(name = "missionId", description = "미션의 아이디, path variable 입니다!")
////            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
//    })
//    public ApiResponse<MemberMission> challengingToComplete( @PathVariable(name = "missionId") Long missionId){
//        MemberMission mission = missionService.challengingToComplete(missionId);
//        return null;
//    }

}
