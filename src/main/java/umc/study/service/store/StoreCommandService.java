package umc.study.service.store;

import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Store addStore(StoreRequestDTO.store request);

    Review addReview(ReviewRequestDTO.requestReview request);
}
