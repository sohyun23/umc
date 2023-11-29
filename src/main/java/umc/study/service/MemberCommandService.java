package umc.study.service;

import umc.study.domain.Member;
import umc.study.web.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);
}
