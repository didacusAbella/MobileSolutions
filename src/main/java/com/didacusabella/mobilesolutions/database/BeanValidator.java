package com.didacusabella.mobilesolutions.database;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author diego
 */
public class BeanValidator<T> {
  
  private static Validator validator;
  
  /**
   *
   * @param bean the bean to validate
   */
   public static <T> boolean validateBean(T bean){
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
    Set<ConstraintViolation<T>> violations = validator.validate(bean);
    return violations.isEmpty();
  }
  
}
