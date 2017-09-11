package demo.service.example

import demo.service.core.Code
import demo.service.core.PropertyIntegerService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ExamplePropertyIntegerService extends PropertyIntegerService() {

    @Value("\${example.property.integer}")
    private val defaultValue: Int? = null

    override def getCode() = Code.EXAMPLE_INTEGER_PROPERTY

    public override def getDefaultValue() = defaultValue!!
}
