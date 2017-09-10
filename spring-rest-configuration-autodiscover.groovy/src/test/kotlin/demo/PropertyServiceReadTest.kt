package demo

import demo.domain.Property
import demo.service.ConfigurationService
import demo.service.core.Code
import demo.service.core.Type
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
class PropertyServiceReadTest {

    @Autowired
    private val configurationService: ConfigurationService? = null

    @Test
    fun findAllPropertiesTest() {
        val properties = configurationService!!.findAllProperties()
        assertThat(properties.size).isEqualTo(4)

        val codeToProperty = properties.map { it.code to it }.toMap()

        assertProperty1(codeToProperty[Code.EXAMPLE_ENUM_PROPERTY]!!)
        assertProperty2(codeToProperty[Code.EXAMPLE_BOOLEAN_PROPERTY]!!)
        assertProperty3(codeToProperty[Code.EXAMPLE_STRING_PROPERTY]!!)
        assertProperty4(codeToProperty[Code.EXAMPLE_INTEGER_PROPERTY]!!)
    }

    @Test
    fun findPropertyByName1Test() {
        val propertyOpt = configurationService!!.findPropertyByName("EXAMPLE_ENUM_PROPERTY")
        assertThat(propertyOpt.isPresent).isEqualTo(true)

        assertProperty1(propertyOpt.get())
    }

    @Test
    fun findPropertyByName2Test() {
        val propertyOpt = configurationService!!.findPropertyByName("EXAMPLE_BOOLEAN_PROPERTY")
        assertThat(propertyOpt.isPresent).isEqualTo(true)

        assertProperty2(propertyOpt.get())
    }

    @Test
    fun findPropertyByName3Test() {
        val propertyOpt = configurationService!!.findPropertyByName("EXAMPLE_STRING_PROPERTY")
        assertThat(propertyOpt.isPresent).isEqualTo(true)

        assertProperty3(propertyOpt.get())
    }

    @Test
    fun findPropertyByName4Test() {
        val propertyOpt = configurationService!!.findPropertyByName("EXAMPLE_INTEGER_PROPERTY")
        assertThat(propertyOpt.isPresent).isEqualTo(true)

        assertProperty4(propertyOpt.get())
    }

    private fun assertProperty1(property: Property) {
        assertThat(property.code).isEqualTo(Code.EXAMPLE_ENUM_PROPERTY)
        assertThat(property.type).isEqualTo(Type.ENUM)
        assertThat(property.value).isEqualTo("ONE")
        assertThat(property.possibleValues.size).isEqualTo(3)
        assertThat(property.possibleValues[0]).isEqualTo("ONE")
        assertThat(property.possibleValues[1]).isEqualTo("TWO")
        assertThat(property.possibleValues[2]).isEqualTo("THREE")
    }

    fun assertProperty2(property: Property) {
        assertThat(property.code).isEqualTo(Code.EXAMPLE_BOOLEAN_PROPERTY)
        assertThat(property.type).isEqualTo(Type.BOOLEAN)
        assertThat(property.value).isEqualTo("true")
        assertThat(property.possibleValues.size).isEqualTo(2)
        assertThat(property.possibleValues[0]).isEqualTo("true")
        assertThat(property.possibleValues[1]).isEqualTo("false")
    }

    fun assertProperty3(property: Property) {
        assertThat(property.code).isEqualTo(Code.EXAMPLE_STRING_PROPERTY)
        assertThat(property.type).isEqualTo(Type.STRING)
        assertThat(property.value).isEqualTo("one")
        assertThat(property.possibleValues.size).isEqualTo(0)
    }

    fun assertProperty4(property: Property) {
        assertThat(property.code).isEqualTo(Code.EXAMPLE_INTEGER_PROPERTY)
        assertThat(property.type).isEqualTo(Type.INTEGER)
        assertThat(property.value).isEqualTo("1")
        assertThat(property.possibleValues.size).isEqualTo(0)
    }
}
