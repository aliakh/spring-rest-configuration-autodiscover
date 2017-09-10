package demo.service.core

abstract class PropertyEnumService<T : Enum<T>> : AbstractPropertyService<T>() {

    override fun getType() = Type.ENUM

    public override fun fromString(input: String?): T =
            if (input == null) getDefaultValue() else java.lang.Enum.valueOf<T>(getEnumClass(), input)

    public override fun toString(input: T?): String =
            input?.toString() ?: getDefaultValue().toString()

    override fun getPossibleValues(): List<String> = getEnumClass().enumConstants.map { it -> it.name }

    protected abstract fun getEnumClass(): Class<T>
}
