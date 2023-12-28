package umc.study.service;

import umc.study.domain.Mission;
import umc.study.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    Mission addMission(MissionRequestDTO.requestMission request);


}
