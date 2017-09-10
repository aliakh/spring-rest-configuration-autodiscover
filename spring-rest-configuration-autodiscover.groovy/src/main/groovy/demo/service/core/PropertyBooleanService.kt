package demo.service.core

import java.util.*

abstract class PropertyBooleanService : AbstractPropertyService<Boolean>() {

    override fun getType() = Type.BOOLEAN

    public override fun fromString(input: String?): Boolean =
            if (input == null) getDefaultValue() else java.lang.Boolean.valueOf(input)

    public override fun toString(input: Boolean?): String =
            input?.toString() ?: getDefaultValue().toString()

    override fun getPossibleValues(): List<String> = Arrays.asList("true", "false")
}
