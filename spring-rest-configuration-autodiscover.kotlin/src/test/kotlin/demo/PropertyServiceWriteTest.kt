package demo

import demo.service.ConfigurationService
import demo.service.example.ExamplePropertyBooleanService
import demo.service.example.ExamplePropertyEnumService
import demo.service.example.ExamplePropertyIntegerService
import demo.service.example.ExamplePropertyStringService
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
class PropertyServiceWriteTest {

    @Autowired
    private val configurationService: ConfigurationService? = null

    @Autowired
    private val examplePropertyEnumService: ExamplePropertyEnumService? = null

    @Autowired
    private val examplePropertyBooleanService: ExamplePropertyBooleanService? = null

    @Autowired
    private val examplePropertyStringService: ExamplePropertyStringService? = null

    @Autowired
    private val examplePropertyIntegerService: ExamplePropertyIntegerService? = null

    @Test
    fun update1Test() {
        examplePropertyEnumService!!.init()
        val value1 = examplePropertyEnumService!!.get()
        assertThat(value1).isEqualTo(ExamplePropertyEnumService.ExampleEnum.ONE)

        configurationService!!.updateProperty("EXAMPLE_ENUM_PROPERTY", "TWO")

        val value2 = examplePropertyEnumService!!.get()
        assertThat(value2).isEqualTo(ExamplePropertyEnumService.ExampleEnum.TWO)
        assertThat(value2).isEqualTo(ExamplePropertyEnumService.ExampleEnum.TWO)
    }

    @Test
    fun update2Test() {
        examplePropertyBooleanService!!.init()
        val value1 = examplePropertyBooleanService!!.get()
        assertThat(value1).isEqualTo(true)

        configurationService!!.updateProperty("EXAMPLE_BOOLEAN_PROPERTY", "false")

        val value2 = examplePropertyBooleanService!!.get()
        assertThat(value2).isEqualTo(false)
        assertThat(value2).isEqualTo(false)
    }

    @Test
    fun update3Test() {
        examplePropertyStringService!!.init()
        val value1 = examplePropertyStringService!!.get()
        assertThat(value1).isEqualTo("one")

        configurationService!!.updateProperty("EXAMPLE_STRING_PROPERTY", "two")

        val value2 = examplePropertyStringService!!.get()
        assertThat(value2).isEqualTo("two")
        assertThat(value2).isEqualTo("two")
    }

    @Test
    fun update4Test() {
        examplePropertyIntegerService!!.init()
        val value1 = examplePropertyIntegerService!!.get()
        assertThat(value1).isEqualTo(1)

        configurationService!!.updateProperty("EXAMPLE_INTEGER_PROPERTY", "2")

        val value2 = examplePropertyIntegerService!!.get()
        assertThat(value2).isEqualTo(2)
        assertThat(value2).isEqualTo(2)
    }
}
