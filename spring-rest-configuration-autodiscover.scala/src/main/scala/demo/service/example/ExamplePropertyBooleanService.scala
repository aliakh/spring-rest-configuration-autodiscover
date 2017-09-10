package demo.service.example

import demo.service.core.Code
import demo.service.core.PropertyBooleanService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ExamplePropertyBooleanService : PropertyBooleanService() {

    @Value("\${example.property.boolean}")
    private val defaultValue: Boolean? = null

    override def getCode() = Code.EXAMPLE_BOOLEAN_PROPERTY

    public override def getDefaultValue() = defaultValue!!
}
