package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    public Store addStore(StoreRequestDTO.store request) {

        Store store = StoreConverter.StoreRequestDTOtoStore(request);
        storeRepository.save(store);
        return store;
    }


}
