package org.reqlist.arch;

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
    
}
