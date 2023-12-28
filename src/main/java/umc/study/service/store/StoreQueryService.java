package umc.study.service.store;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);

    Page<Mission> getMissionList(Long StoreId, Integer page);

}