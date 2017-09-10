package demo.service.example;

import demo.service.core.Code;
import demo.service.core.PropertyEnumService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExamplePropertyEnumService extends PropertyEnumService<ExamplePropertyEnumService.ExampleEnum> {

    @Value("${example.property.enum}")
    private ExampleEnum defaultValue;

    @Override
    public Code getCode() {
        return Code.EXAMPLE_ENUM_PROPERTY;
    }

    @Override
    public ExampleEnum getDefaultValue() {
        return defaultValue;
    }

    @Override
    public Class<ExampleEnum> getEnumClass() {
        return ExampleEnum.class;
    }

    public enum ExampleEnum {
        ONE,
        TWO,
        THREE,
    }
}
