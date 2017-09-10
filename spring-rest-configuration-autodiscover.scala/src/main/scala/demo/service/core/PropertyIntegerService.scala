package demo.service.core

abstract class PropertyIntegerService : AbstractPropertyService<Int>() {

    override fun getType() = Type.INTEGER

    public override fun fromString(input: String?): Int =
            if (input == null) getDefaultValue() else Integer.valueOf(input)

    public override fun toString(input: Int?): String =
            input?.toString() ?: getDefaultValue().toString()
}
