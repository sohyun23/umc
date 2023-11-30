package umc.study.web.dto;

import lombok.Getter;
import umc.study.validation.annotation.ExistStore;

import javax.validation.constraints.NotBlank;

public class ReviewRequestDTO {
    @Getter
    public static class review{
        @NotBlank
        String title;
        @NotBlank
        Float score;
        @ExistStore
        Long store;

    }
}
