//package umc.study.web.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import umc.study.apiPayload.ApiResponse;
//import umc.study.converter.MissionConverter;
//import umc.study.domain.Mission;
//import umc.study.service.MissionService;
//import umc.study.web.dto.MissionRequestDTO;
//import umc.study.web.dto.MissionResponseDTO;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/mission")
//public class MissionRestController {
//
//    private final MissionService missionService;
//
//    @PostMapping("/")
//    public ApiResponse<MissionResponseDTO.mission> add(@RequestBody @Validated MissionRequestDTO.mission request){
//        Mission mission = missionService.addMission(request);
//        return ApiResponse.onSuccess(MissionConverter.toMissionResponseDTO(mission));
//    }
//
//    @PostMapping("/")
//    public ApiResponse<MissionResponseDTO.mission> add(@RequestBody @Validated MissionRequestDTO.mission request){
//        Mission mission = missionService.addMission(request);
//        return ApiResponse.onSuccess(MissionConverter.toMissionResponseDTO(mission));
//    }
//}
