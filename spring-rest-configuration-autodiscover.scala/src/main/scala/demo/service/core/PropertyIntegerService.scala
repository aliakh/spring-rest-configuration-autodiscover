package demo.service.core

abstract class PropertyIntegerService extends AbstractPropertyService[Int] {

  override def getType: Type.Value = Type.INTEGER

  override def fromString(input: String): Int =
    if (input == null) getDefaultValue else Integer.valueOf(input)

  override def toString(input: Int): String =
    if (input == null) getDefaultValue.toString else String.valueOf(input)
}
