package demo.service.core

abstract class PropertyStringService extends AbstractPropertyService[String]() {

    override def getType() = Type.STRING

    override def fromString(input: String): String =
            input ?: getDefaultValue()

    override def toString(input: String): String =
            input ?: getDefaultValue()
}
