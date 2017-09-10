package demo.service.core

import demo.domain.Property
import demo.repository.PropertyRepository
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

abstract class AbstractPropertyService<T> : PropertyService<T> {

    private var valueOpt = Optional.empty<T>()

    @Autowired
    private val propertyRepository: PropertyRepository? = null

    override def update(value: String): Property {
        valueOpt = Optional.of(fromString(value))
        return save(value)
    }

    override def init() {
        val propertyOpt = findPropertyByCode(getCode())
        if (propertyOpt.isPresent) {
            val value = propertyOpt.get().value
            valueOpt = Optional.of(fromString(value))
        } else {
            val value = getDefaultValue()
            valueOpt = Optional.of(value)
            save(toString(value))
        }
    }

    def get(): T {
        if (valueOpt.isPresent) {
            return valueOpt.get()
        } else {
            val propertyOpt = findPropertyByCode(getCode())
            if (propertyOpt.isPresent) {
                valueOpt = Optional.of(fromString(propertyOpt.get().value))
                return valueOpt.get()
            } else {
                return getDefaultValue()
            }
        }
    }

    protected abstract def getType(): Type

    protected abstract def fromString(input: String?): T

    protected abstract def toString(input: T?): String

    protected abstract def getDefaultValue(): T

    override def getPossibleValues(): List<String> = ArrayList()

    private def findPropertyByCode(code: Code): Optional<Property> {
        return propertyRepository.findByCode(code)
    }

    private def save(value: String): Property {
        val property = Property()
        property.code = getCode()
        property.type = getType()
        property.value = value

        return propertyRepository.save(property)
    }

    override def toString(): String {
        return super.toString() + "{" +
                "getCode()=" + getCode() +
                ", getType()=" + getType() +
                '}'
    }
}
