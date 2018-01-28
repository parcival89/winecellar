package be.sander.winecellar.infrastructure.validation;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static javax.validation.Validation.buildDefaultValidatorFactory;

public class WinecellarValidator {

    private static WinecellarValidator instance;

    public static WinecellarValidator validator() {
        if (instance == null) {
            instance = new WinecellarValidator();
        }
        return instance;
    }

    private Validator validator;

    private WinecellarValidator() {
        validator = buildDefaultValidatorFactory().getValidator();
    }

    public void validate(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(
                    constraintViolationErrorMessage(violations),
                    new HashSet<ConstraintViolation<?>>(violations));
        }
    }

    private String constraintViolationErrorMessage(Set<ConstraintViolation<Object>> violations) {
        return violations.stream()
                .map(violation -> format("%s#%s can not have value %s because %s",
                        violation.getRootBeanClass(),
                        violation.getPropertyPath(),
                        violation.getInvalidValue(),
                        violation.getMessage()))
                .collect(Collectors.joining(", "));
    }
}
