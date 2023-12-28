package umc.study.validation.annotation;

import umc.study.validation.validator.CheckPageValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "Page 범위가 너무 작습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}