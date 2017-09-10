package demo

import demo.service.ConfigurationService
import demo.service.example.ExamplePropertyBooleanService
import demo.service.example.ExamplePropertyEnumService
import demo.service.example.ExamplePropertyIntegerService
import demo.service.example.ExamplePropertyStringService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

import static org.assertj.core.api.Assertions.assertThat

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class PropertyServiceWriteTest {

    @Autowired
    private ConfigurationService configurationService

    @Autowired
    private ExamplePropertyEnumService examplePropertyEnumService

    @Autowired
    private ExamplePropertyBooleanService examplePropertyBooleanService

    @Autowired
    private ExamplePropertyStringService examplePropertyStringService

    @Autowired
    private ExamplePropertyIntegerService examplePropertyIntegerService

    @Test
    void update1Test() {
        examplePropertyEnumService.init()
        final ExamplePropertyEnumService.ExampleEnum value1 = examplePropertyEnumService.get()
        assertThat(value1).isEqualTo(ExamplePropertyEnumService.ExampleEnum.ONE)

        configurationService.updateProperty("EXAMPLE_ENUM_PROPERTY", "TWO")

        final ExamplePropertyEnumService.ExampleEnum value2 = examplePropertyEnumService.get()
        assertThat(value2).isEqualTo(ExamplePropertyEnumService.ExampleEnum.TWO)
        assertThat(value2).isEqualTo(ExamplePropertyEnumService.ExampleEnum.TWO)
    }

    @Test
    void update2Test() {
        examplePropertyBooleanService.init()
        final boolean value1 = examplePropertyBooleanService.get()
        assertThat(value1).isEqualTo(true)

        configurationService.updateProperty("EXAMPLE_BOOLEAN_PROPERTY", "false")

        final boolean value2 = examplePropertyBooleanService.get()
        assertThat(value2).isEqualTo(false)
        assertThat(value2).isEqualTo(false)
    }

    @Test
    void update3Test() {
        examplePropertyStringService.init()
        final String value1 = examplePropertyStringService.get()
        assertThat(value1).isEqualTo("one")

        configurationService.updateProperty("EXAMPLE_STRING_PROPERTY", "two")

        final String value2 = examplePropertyStringService.get()
        assertThat(value2).isEqualTo("two")
        assertThat(value2).isEqualTo("two")
    }

    @Test
    void update4Test() {
        examplePropertyIntegerService.init()
        final int value1 = examplePropertyIntegerService.get()
        assertThat(value1).isEqualTo(1)

        configurationService.updateProperty("EXAMPLE_INTEGER_PROPERTY", "2")

        final int value2 = examplePropertyIntegerService.get()
        assertThat(value2).isEqualTo(2)
        assertThat(value2).isEqualTo(2)
    }
}
