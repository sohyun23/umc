package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.mission request) {
        return Mission.builder()
                .reward(request.getReward())
                .deadline(LocalDate.from(request.getDeadline()))
                .missionSpec(request.getMissionSpec())
//                .memberMissionList(new ArrayList<>())
                .build();
    }

    public static MissionResponseDTO.mission toMissionResponseDTO(Mission mission){
        return MissionResponseDTO.mission.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
