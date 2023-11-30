package umc.study.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.enums.MissionStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MissionStatusValidator implements ConstraintValidator<Enum, MissionStatus> {

    @Override
    public void initialize(Enum constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionStatus value, ConstraintValidatorContext context) {
        boolean isValid = false;

        if (value != null && value.equals(MissionStatus.CHALLENGING)) {
            isValid = true;
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_STATUS_NOT_CHALLENGING.toString()).addConstraintViolation();
        }

    }
}
