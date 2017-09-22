package demo.domain

import javax.persistence.{AttributeConverter, Converter}

import demo.service.core.Type

@Converter class TypeConverter extends AttributeConverter[Type.Value, String] {

  override def convertToDatabaseColumn(attribute: Type.Value): String = attribute.toString

  override def convertToEntityAttribute(dbData: String): Type.Value = Type.withName(dbData)
}