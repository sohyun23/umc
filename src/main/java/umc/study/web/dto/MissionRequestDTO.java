package umc.study.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class MissionRequestDTO {

    @Getter
    public static class mission{
        @NotBlank
        Integer reward;

        @NotNull
        Integer deadlineYear;
        @NotNull
        Integer deadlineMonth;

        @NotNull
        Integer deadlineDay;

        @NotNull
        String missionSpec;

        List<Long> memberMission;
    }
}
