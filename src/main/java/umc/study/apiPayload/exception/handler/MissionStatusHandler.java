package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class MissionStatusHandler extends GeneralException {

    public MissionStatusHandler(BaseErrorCode code) {
        super(code);
    }
}
