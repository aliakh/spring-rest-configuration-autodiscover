package demo

import demo.domain.Property
import demo.service.ConfigurationService
import demo.service.core.Code
import demo.service.core.Type
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

import java.util.stream.Collectors

import static org.assertj.core.api.Assertions.assertThat

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class PropertyServiceReadTest {

    @Autowired
    private ConfigurationService configurationService

    @Test
    void findAllPropertiesTest() {
        List<Property> properties = configurationService.findAllProperties()
        assertThat(properties.size()).isEqualTo(4)

        Map<Code, Property> codeToProperty = properties.stream().collect(Collectors.toMap(Property::getCode, configuration -> configuration))

        assertProperty1(codeToProperty.get(Code.EXAMPLE_ENUM_PROPERTY))
        assertProperty2(codeToProperty.get(Code.EXAMPLE_BOOLEAN_PROPERTY))
        assertProperty3(codeToProperty.get(Code.EXAMPLE_STRING_PROPERTY))
        assertProperty4(codeToProperty.get(Code.EXAMPLE_INTEGER_PROPERTY))
    }

    @Test
    void findPropertyByName1Test() {
        Optional<Property> propertyOpt = configurationService.findPropertyByName("EXAMPLE_ENUM_PROPERTY")
        assertThat(propertyOpt.isPresent()).isEqualTo(true)

        assertProperty1(propertyOpt.get())
    }

    @Test
    void findPropertyByName2Test() {
        Optional<Property> propertyOpt = configurationService.findPropertyByName("EXAMPLE_BOOLEAN_PROPERTY")
        assertThat(propertyOpt.isPresent()).isEqualTo(true)

        assertProperty2(propertyOpt.get())
    }

    @Test
    void findPropertyByName3Test() {
        Optional<Property> propertyOpt = configurationService.findPropertyByName("EXAMPLE_STRING_PROPERTY")
        assertThat(propertyOpt.isPresent()).isEqualTo(true)

        assertProperty3(propertyOpt.get())
    }

    @Test
    void findPropertyByName4Test() {
        Optional<Property> propertyOpt = configurationService.findPropertyByName("EXAMPLE_INTEGER_PROPERTY")
        assertThat(propertyOpt.isPresent()).isEqualTo(true)

        assertProperty4(propertyOpt.get())
    }

    private void assertProperty1(Property property) {
        assertThat(property.getCode()).isEqualTo(Code.EXAMPLE_ENUM_PROPERTY)
        assertThat(property.getType()).isEqualTo(Type.ENUM)
        assertThat(property.getValue()).isEqualTo("ONE")
        assertThat(property.getPossibleValues().size()).isEqualTo(3)
        assertThat(property.getPossibleValues().get(0)).isEqualTo("ONE")
        assertThat(property.getPossibleValues().get(1)).isEqualTo("TWO")
        assertThat(property.getPossibleValues().get(2)).isEqualTo("THREE")
    }

    private void assertProperty2(Property property) {
        assertThat(property.getCode()).isEqualTo(Code.EXAMPLE_BOOLEAN_PROPERTY)
        assertThat(property.getType()).isEqualTo(Type.BOOLEAN)
        assertThat(property.getValue()).isEqualTo("true")
        assertThat(property.getPossibleValues().size()).isEqualTo(2)
        assertThat(property.getPossibleValues().get(0)).isEqualTo("true")
        assertThat(property.getPossibleValues().get(1)).isEqualTo("false")
    }

    private void assertProperty3(Property property) {
        assertThat(property.getCode()).isEqualTo(Code.EXAMPLE_STRING_PROPERTY)
        assertThat(property.getType()).isEqualTo(Type.STRING)
        assertThat(property.getValue()).isEqualTo("one")
        assertThat(property.getPossibleValues().size()).isEqualTo(0)
    }

    private void assertProperty4(Property property) {
        assertThat(property.getCode()).isEqualTo(Code.EXAMPLE_INTEGER_PROPERTY)
        assertThat(property.getType()).isEqualTo(Type.INTEGER)
        assertThat(property.getValue()).isEqualTo("1")
        assertThat(property.getPossibleValues().size()).isEqualTo(0)
    }
}
