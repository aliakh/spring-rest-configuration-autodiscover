package demo.service.core

abstract class PropertyStringService : AbstractPropertyService<String>() {

    override fun getType() = Type.STRING

    public override fun fromString(input: String?): String =
            input ?: getDefaultValue()

    public override fun toString(input: String?): String =
            input ?: getDefaultValue()
}
