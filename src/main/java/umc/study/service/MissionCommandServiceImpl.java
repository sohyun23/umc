package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.repository.MissionRepository;
import umc.study.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl {

    public final MissionRepository missionRepository;

    @Transactional
    public Mission addMission(MissionRequestDTO.mission request) {
        Mission mission = MissionConverter.toMission(request);

        return missionRepository.save(mission);
    }

    @Transactional
    public Mission addChellengingMission(MissionRequestDTO.challengingMission request) {
        Mission mission = MissionConverter.toChallengingMission(request);

        return missionRepository.save(mission);
    }
}
