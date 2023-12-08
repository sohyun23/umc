package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.ReviewConverter;
import umc.study.converter.StoreConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.store request) {
        Store store = StoreConverter.toStore(request);
        return storeRepository.save(store);
    }

    @Transactional
    public Review addReview(ReviewRequestDTO.review request) {
        Member member = memberRepository.findById(request.getMemberId()).get();
        Store store =  storeRepository.findById(request.getStoreId()).get();


        Review review = ReviewConverter.toReview(request, member, store);
        return reviewRepository.save(review);

    }
}
