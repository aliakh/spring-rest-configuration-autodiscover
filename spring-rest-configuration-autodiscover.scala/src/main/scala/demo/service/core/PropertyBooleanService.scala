package demo.service.core

import java.util.*

abstract class PropertyBooleanService : AbstractPropertyService<Boolean>() {

    override def getType() = Type.BOOLEAN

    public override def fromString(input: String?): Boolean =
            if (input == null) getDefaultValue() else java.lang.Boolean.valueOf(input)

    public override def toString(input: Boolean?): String =
            input?.toString() ?: getDefaultValue().toString()

    override def getPossibleValues(): List<String> = Arrays.asList("true", "false")
}
