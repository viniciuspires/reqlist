package org.reqlist.arch;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */

@Component
public class ValidatorProvider {
    private final Validator validator;

    public ValidatorProvider() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        
    }
    
    public Validator validator() {
        return validator;
    }
    
    /**
     * @param object
     */
    public void basicValidate(Object object) {
        Set<ConstraintViolation<Object>> violations = validator().validate(object);
    }
    
}
