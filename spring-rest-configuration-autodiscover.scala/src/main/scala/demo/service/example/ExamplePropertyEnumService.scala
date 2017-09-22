package demo.service.example

import demo.service.core.{Code, PropertyEnumService}
import demo.service.example.ExampleEnum
import demo.service.example.ExampleEnum.ExampleEnum
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ExamplePropertyEnumService extends PropertyEnumService[ExampleEnum.ExampleEnum] {

  @Value("${example.property.enum}")
  private val defaultValue: String = null

  override def getCode: Code.Value = Code.EXAMPLE_ENUM_PROPERTY

  override def getDefaultValue: ExampleEnum.Value = ExampleEnum.withName(defaultValue)

  override def getEnumClass: Class[ExampleEnum.ExampleEnum] = classOf[ExampleEnum.ExampleEnum]
}

object ExampleEnum extends Enumeration {
  type ExampleEnum = Value
  val ONE, TWO, THREE = Value
}