package demo.service.core

abstract class PropertyStringService : AbstractPropertyService<String>() {

    override def getType() = Type.STRING

    public override def fromString(input: String?): String =
            input ?: getDefaultValue()

    public override def toString(input: String?): String =
            input ?: getDefaultValue()
}
