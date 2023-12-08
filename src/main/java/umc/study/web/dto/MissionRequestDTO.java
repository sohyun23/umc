package umc.study.web.dto;

import lombok.Getter;
import umc.study.validation.annotation.ExistStore;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class mission{
        @NotNull
        Integer reward;

//        @NotNull
        LocalDateTime deadline;

        @NotNull
        String missionSpec;

        @ExistStore
        Long storeId;


    }
}
