//package umc.study.validation.validator;
//
//import umc.study.repository.RegionRepository;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//import java.lang.annotation.Annotation;
//
//public class RegionExistValidator implements ConstraintValidator {
//    @Override
//    public void initialize(Annotation constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
//    }
//
//    @Override
//    public boolean isValid(Long value, ConstraintValidatorContext context) {
//        if (value == null) {
//            // null 값 처리, null은 유효하지 않다고 가정합니다
//            return false;
//        }
//
//        boolean isValid;
//        if (RegionRepository.existsById(value)) isValid = true;
//        else isValid = false;
//
////        if (!isValid) {
////            context.disableDefaultConstraintViolation();
////            context.buildConstraintViolationWithTemplate(ErrorStatus.REGION_NOT_FOUND.toString()).addConstraintViolation();
////        }
//
//
//        return false;
//    }
//}
