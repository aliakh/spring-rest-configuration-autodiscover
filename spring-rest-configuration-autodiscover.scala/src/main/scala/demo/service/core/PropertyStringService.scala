package demo.service.core

abstract class PropertyStringService extends AbstractPropertyService[String] {

  override def getType: Type.Value = Type.STRING

  override def fromString(input: String): String =
    if (input == null) getDefaultValue else input

  override def toString(input: String): String =
    if (input == null) getDefaultValue else input
}
