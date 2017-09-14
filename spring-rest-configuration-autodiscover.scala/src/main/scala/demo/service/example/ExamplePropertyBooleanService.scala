package demo.service.example

import demo.service.core.{Code, PropertyBooleanService}
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ExamplePropertyBooleanService extends PropertyBooleanService {

  @Value("${example.property.boolean}")
  private val defaultValue: Boolean = null

  override def getCode: Code.Value = Code.EXAMPLE_BOOLEAN_PROPERTY

  override def getDefaultValue: Boolean = defaultValue
}
