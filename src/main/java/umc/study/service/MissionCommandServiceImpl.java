package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository;
import umc.study.service.store.StoreQueryServiceImpl;
import umc.study.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl {

    public final MissionRepository missionRepository;
    public final StoreQueryServiceImpl storeQueryService;
    @Transactional
    public Mission addMission(MissionRequestDTO.requestMission request) {
        Mission mission = MissionConverter.toMission(request);
        Store store = storeQueryService.findStore(request.getStoreId()).get();
        mission.setStore(store);

        return missionRepository.save(mission);
    }

    @Transactional
    public Mission addChellengingMission(MissionRequestDTO.challengingMission request) {
        Mission mission = MissionConverter.toChallengingMission(request);

        return missionRepository.save(mission);
    }

//    public MemberMission challengingToComplete(Long missionId) {
//        Mission mission = missionRepository.findById(missionId);
//    }
}
