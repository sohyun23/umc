package umc.study.validation.annotation;

import umc.study.validation.validator.MissionStatusValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionStatusValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMissionStatus {

    String message() default "도전 중인 미션이 아닙니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
//    Class<? extends java.lang.Enum<?>> enumClass();
}
