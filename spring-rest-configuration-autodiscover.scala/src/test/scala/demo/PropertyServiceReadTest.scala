package demo

import demo.domain.Property
import demo.service.ConfigurationService
import demo.service.core.{Code, Type}
import org.assertj.core.api.Assertions._
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

import scala.collection.JavaConverters._

@RunWith(classOf[SpringRunner])
@SpringBootTest
@Transactional
class PropertyServiceReadTest {

  @Autowired
  private val configurationService: ConfigurationService = null

  @Test
  def findAllPropertiesTest() {
    val properties = configurationService.findAllProperties()
    assertThat(properties.size).isEqualTo(4)

    val codeToProperty: Map[Code.Value, Property] = properties
      .asScala
      .map(property => property.code -> property)
      .toMap

    assertProperty1(codeToProperty.get(Code.EXAMPLE_ENUM_PROPERTY).get)
    assertProperty2(codeToProperty.get(Code.EXAMPLE_BOOLEAN_PROPERTY).get)
    assertProperty3(codeToProperty.get(Code.EXAMPLE_STRING_PROPERTY).get)
    assertProperty4(codeToProperty.get(Code.EXAMPLE_INTEGER_PROPERTY).get)
  }

  @Test
  def findPropertyByName1Test() {
    val propertyOpt = configurationService.findPropertyByName("EXAMPLE_ENUM_PROPERTY")
    assertThat(propertyOpt.isPresent).isEqualTo(true)

    assertProperty1(propertyOpt.get())
  }

  @Test
  def findPropertyByName2Test() {
    val propertyOpt = configurationService.findPropertyByName("EXAMPLE_BOOLEAN_PROPERTY")
    assertThat(propertyOpt.isPresent).isEqualTo(true)

    assertProperty2(propertyOpt.get())
  }

  @Test
  def findPropertyByName3Test() {
    val propertyOpt = configurationService.findPropertyByName("EXAMPLE_STRING_PROPERTY")
    assertThat(propertyOpt.isPresent).isEqualTo(true)

    assertProperty3(propertyOpt.get())
  }

  @Test
  def findPropertyByName4Test() {
    val propertyOpt = configurationService.findPropertyByName("EXAMPLE_INTEGER_PROPERTY")
    assertThat(propertyOpt.isPresent).isEqualTo(true)

    assertProperty4(propertyOpt.get())
  }

  private def assertProperty1(property: Property) {
    assertThat(property.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(Code.EXAMPLE_ENUM_PROPERTY)
    assertThat(property.`type`.asInstanceOf[Ordered[Type.Type]]).isEqualTo(Type.ENUM)
    assertThat(property.value).isEqualTo("ONE")
    assertThat(property.possibleValues.size).isEqualTo(3)
    assertThat(property.possibleValues.get(0)).isEqualTo("ONE")
    assertThat(property.possibleValues.get(1)).isEqualTo("TWO")
    assertThat(property.possibleValues.get(2)).isEqualTo("THREE")
  }

  private def assertProperty2(property: Property) {
    assertThat(property.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(Code.EXAMPLE_BOOLEAN_PROPERTY)
    assertThat(property.`type`.asInstanceOf[Ordered[Type.Type]]).isEqualTo(Type.BOOLEAN)
    assertThat(property.value).isEqualTo("true")
    assertThat(property.possibleValues.size).isEqualTo(2)
    assertThat(property.possibleValues.get(0)).isEqualTo("true")
    assertThat(property.possibleValues.get(1)).isEqualTo("false")
  }

  private def assertProperty3(property: Property) {
    assertThat(property.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(Code.EXAMPLE_STRING_PROPERTY)
    assertThat(property.`type`.asInstanceOf[Ordered[Type.Type]]).isEqualTo(Type.STRING)
    assertThat(property.value).isEqualTo("one")
    assertThat(property.possibleValues.size).isEqualTo(0)
  }

  private def assertProperty4(property: Property) {
    assertThat(property.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(Code.EXAMPLE_INTEGER_PROPERTY)
    assertThat(property.`type`.asInstanceOf[Ordered[Type.Type]]).isEqualTo(Type.INTEGER)
    assertThat(property.value).isEqualTo("1")
    assertThat(property.possibleValues.size).isEqualTo(0)
  }
}
