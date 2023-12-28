package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    @Query("SELECT mm FROM MemberMission mm WHERE mm.member = :member AND mm.status = 'CHALLENGING'")
    Page<MemberMission> findAllByMemberAndStatus(
            @Param("member") Member member,
            PageRequest pageRequest);


}
