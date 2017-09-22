package demo.domain

import javax.persistence.AttributeConverter
import javax.persistence.Converter

import demo.service.core.Code

@Converter(autoApply = true)
class CodeConverter extends AttributeConverter[Code.Value, String] {

  override def convertToDatabaseColumn(attribute: Code.Value): String =
    attribute.toString

  override def convertToEntityAttribute(dbData: String): Code.Value =
    Code.withName(dbData)
}