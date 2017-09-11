package demo.service.core

import java.util._

abstract class PropertyBooleanService extends AbstractPropertyService[Boolean]() {

    override def getType: Type.Value = Type.BOOLEAN

    override def fromString(input: String): Boolean =
            if (input == null) getDefaultValue else java.lang.Boolean.valueOf(input)

    override def toString(input: Boolean): String =
            input.toString() ?: getDefaultValue.toString()

    override def getPossibleValues(): List[String] = Arrays.asList("true", "false")
}
