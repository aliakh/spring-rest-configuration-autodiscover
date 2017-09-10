package demo.service.example

import demo.service.core.Code
import demo.service.core.PropertyEnumService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ExamplePropertyEnumService : PropertyEnumService<ExamplePropertyEnumService.ExampleEnum>() {

    @Value("\${example.property.enum}")
    private val defaultValue: ExampleEnum? = null

    override fun getCode() = Code.EXAMPLE_ENUM_PROPERTY

    public override fun getDefaultValue() = defaultValue!!

    override fun getEnumClass(): Class<ExampleEnum> = ExampleEnum::class.java

    enum class ExampleEnum {
        ONE,
        TWO,
        THREE
    }
}
