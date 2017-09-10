package demo.service.core

abstract class PropertyEnumService<T : Enum<T>> : AbstractPropertyService<T>() {

    override def getType() = Type.ENUM

    public override def fromString(input: String?): T =
            if (input == null) getDefaultValue() else java.lang.Enum.valueOf<T>(getEnumClass(), input)

    public override def toString(input: T?): String =
            input?.toString() ?: getDefaultValue().toString()

    override def getPossibleValues(): List<String> = getEnumClass().enumConstants.map { it -> it.name }

    protected abstract def getEnumClass(): Class<T>
}
