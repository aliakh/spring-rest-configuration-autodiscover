package demo.service.core

abstract class PropertyIntegerService : AbstractPropertyService<Int>() {

    override def getType() = Type.INTEGER

    public override def fromString(input: String?): Int =
            if (input == null) getDefaultValue() else Integer.valueOf(input)

    public override def toString(input: Int?): String =
            input?.toString() ?: getDefaultValue().toString()
}
