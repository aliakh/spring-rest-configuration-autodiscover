package demo.service.core

abstract class PropertyEnumService[T: Enum[T]] extends AbstractPropertyService[T] {

  override def getType: Type.Value = Type.ENUM

  override def fromString(input: String): T =
    if (input == null) getDefaultValue else Enum.valueOf[T](getEnumClass, input)

  override def toString(input: T): String =
    if (input == null) getDefaultValue.toString else String.valueOf(input)

  override def getPossibleValues: List[String] = getEnumClass.getEnumConstants.map({ it => it.name })

  protected abstract def getEnumClass: Class[T]
}
