package umc.study.converter;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.store request){

        Region region = Region.builder()
                .id(request.getRegionId())
                .name(request.getRegionName())
                .build();




        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .score(request.getScore())
                .region(region)
                .build();
    }

    public static StoreResponseDTO.storeResult toStoreResponseDTO(Store store){
        return StoreResponseDTO.storeResult.builder()
                                    .storeId(store.getId())
                                    .createdAt(LocalDateTime.now())
                                    .build();
    }
}
