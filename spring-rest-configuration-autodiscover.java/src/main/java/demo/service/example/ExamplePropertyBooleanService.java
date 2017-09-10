package demo.service.example;

import demo.service.core.Code;
import demo.service.core.PropertyBooleanService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExamplePropertyBooleanService extends PropertyBooleanService {

    @Value("${example.property.boolean}")
    private boolean defaultValue;

    @Override
    public Code getCode() {
        return Code.EXAMPLE_BOOLEAN_PROPERTY;
    }

    @Override
    public Boolean getDefaultValue() {
        return defaultValue;
    }
}
