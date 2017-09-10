package demo.service.example

import demo.service.core.Code
import demo.service.core.PropertyStringService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ExamplePropertyStringService : PropertyStringService() {

    @Value("\${example.property.string}")
    private val defaultValue: String? = null

    override fun getCode() = Code.EXAMPLE_STRING_PROPERTY

    public override fun getDefaultValue() = defaultValue!!
}
