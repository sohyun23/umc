package umc.study.converter;

import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public class StoreConverter {

    public static Store StoreRequestDTOtoStore(StoreRequestDTO.store request){

        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .score(request.getScore())
                .build();
    }

    public static StoreResponseDTO.store StoretoStoreResponseDTO(Store store){
        return StoreResponseDTO.store.builder()
                                    .storeId(store.getId())
                                    .name(store.getName())
                                    .address(store.getAddress())
                                    .score(store.getScore())
                                    .build();
    }
}
