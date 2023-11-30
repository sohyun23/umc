package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.service.StoreService;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {

    private final StoreService storeService;

    @PostMapping("/add")
    public StoreResponseDTO.store add(@RequestBody @Validated StoreRequestDTO.store request){
        Store store = storeService.addStore(request);
        return StoreConverter.StoretoStoreResponseDTO(store);
    }
}
