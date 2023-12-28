package umc.study.service.member;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

    Page<Review> getMyReviewList(Long MemberId, Integer page);

    Page<MemberMission> getChallengingMissionList(Long MemberId, Integer page);

}