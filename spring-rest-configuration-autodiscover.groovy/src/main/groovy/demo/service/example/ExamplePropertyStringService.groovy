package demo.service.example

import demo.service.core.Code
import demo.service.core.PropertyStringService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ExamplePropertyStringService extends PropertyStringService {

    @Value("${example.property.string}")
    private String defaultValue

    @Override
    Code getCode() {
        return Code.EXAMPLE_STRING_PROPERTY
    }

    @Override
    String getDefaultValue() {
        return defaultValue
    }
}
