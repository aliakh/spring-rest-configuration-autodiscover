package demo.service.core

import scala.collection.JavaConverters.seqAsJavaList

abstract class PropertyEnumService[T <: Enumeration#Value] extends AbstractPropertyService[T] {

  override def getType: Type.Value = Type.ENUM

  override def fromString(input: String): T =
    if (input == null)
      getDefaultValue
    else
      getEnumValues.toList.find(it => it.toString.equals(input)).get

  override def toString(input: T): String =
    if (input == null) getDefaultValue.toString else String.valueOf(input)

  override def getPossibleValues: java.util.List[String] = seqAsJavaList[String](getEnumValues.map({ it => it.toString }).toList)

  protected def getEnumValues: Set[T]
}
