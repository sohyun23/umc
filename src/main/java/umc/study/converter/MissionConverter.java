package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.requestMission request) {
        return Mission.builder()
                .reward(request.getReward())
                .deadline(LocalDate.from(request.getDeadline()))
                .missionSpec(request.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.mission toMissionResponseDTO(Mission mission){
        return MissionResponseDTO.mission.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toChallengingMission(MissionRequestDTO.challengingMission request) {
        return Mission.builder()
                .reward(request.getReward())
                .deadline(LocalDate.from(request.getDeadline()))
                .missionSpec(request.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .missionSpec(mission.getMissionSpec())
                .deadline(mission.getDeadline())
                .reward(mission.getReward())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }
    public static MissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){

        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewListDTO = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewListDTO.size())
                .missionList(missionPreViewListDTO)
                .build();
    }


    public static MissionResponseDTO.MissionPreViewListDTO memberMissionToMissionPreViewListDTO(Page<MemberMission> missionList){



        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewListDTO = missionList.getContent().stream()
                .map(MemberMission::getMission).map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewListDTO.size())
                .missionList(missionPreViewListDTO)
                .build();
    }

}


