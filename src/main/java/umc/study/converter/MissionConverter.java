package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.util.ArrayList;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.mission request) {
        return Mission.builder()
                .reward(request.getReward())
                .missionSpec(request.getMissionSpec())
                .memberMissionList(new ArrayList<>())
                .build();
    }

    public static MissionResponseDTO.mission toMissionResponseDTO(Mission mission){
        return MissionResponseDTO.mission.builder()
                .missionId(mission.getId())
                .reward(mission.getReward())
//                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }
}
