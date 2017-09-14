package demo.service.example

import demo.service.core.{Code, PropertyEnumService}
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ExamplePropertyEnumService extends PropertyEnumService[ExamplePropertyEnumService.ExampleEnum] {

    @Value("${example.property.enum}")
    private val defaultValue: String = null

    override def getCode: Code.Value = Code.EXAMPLE_ENUM_PROPERTY

    override def getDefaultValue = ExampleEnum.withName(defaultValue)

    override def getEnumClass: Class[ExampleEnum] = ExampleEnum.getClass

  object ExampleEnum extends Enumeration {
    type Type = Value
    val ONE, TWO, THREE = Value
  }
}
