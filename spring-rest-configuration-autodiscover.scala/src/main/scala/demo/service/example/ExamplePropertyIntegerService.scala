package demo.service.example

import demo.service.core.{Code, PropertyIntegerService}
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ExamplePropertyIntegerService extends PropertyIntegerService() {

  @Value("${example.property.integer}")
  private val defaultValue: Int = null

  override def getCode: Code.Value = Code.EXAMPLE_INTEGER_PROPERTY

  override def getDefaultValue: Int = defaultValue
}
