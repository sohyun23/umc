package umc.study.web.dto;

import lombok.Getter;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistStore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReviewRequestDTO {
    @Getter
    public static class requestReview{
        @NotBlank
        String title;
//        @NotNull
        String body;
        @NotNull
        Float score;
        @ExistMember
        Long memberId;
        @ExistStore
        Long storeId;

    }


}
