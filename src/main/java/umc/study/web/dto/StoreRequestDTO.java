package umc.study.web.dto;

import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class store{
        String name;
        String address;
        Float score;
        Long regionId;
        String regionName;

    }


}
