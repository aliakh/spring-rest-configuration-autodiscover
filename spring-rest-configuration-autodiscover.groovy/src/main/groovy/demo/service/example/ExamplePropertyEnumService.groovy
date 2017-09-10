package demo.service.example

import demo.service.core.Code
import demo.service.core.PropertyEnumService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ExamplePropertyEnumService extends PropertyEnumService<ExamplePropertyEnumService.ExampleEnum> {

    @Value("${example.property.enum}")
    private ExampleEnum defaultValue

    @Override
    Code getCode() {
        return Code.EXAMPLE_ENUM_PROPERTY
    }

    @Override
    ExampleEnum getDefaultValue() {
        return defaultValue
    }

    @Override
    Class<ExampleEnum> getEnumClass() {
        return ExampleEnum.class
    }

    enum ExampleEnum {
        ONE,
        TWO,
        THREE,
    }
}
