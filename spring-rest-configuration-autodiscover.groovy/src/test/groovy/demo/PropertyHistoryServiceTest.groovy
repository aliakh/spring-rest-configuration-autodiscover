package demo

import demo.domain.PropertyHistory
import demo.service.ConfigurationHistoryService
import demo.service.ConfigurationService
import demo.service.core.Code
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
class PropertyHistoryServiceTest {

    @Autowired
    private ConfigurationService configurationService

    @Autowired
    private ConfigurationHistoryService configurationHistoryService

    @Test
    void findAllHistory1Test() {
        final Code code = Code.EXAMPLE_ENUM_PROPERTY
        final String name = "EXAMPLE_ENUM_PROPERTY"
        final String value1 = "ONE"
        final String value2 = "TWO"
        final String value3 = "THREE"

        final List<PropertyHistory> propertyHistoriesA = configurationHistoryService.findAllPropertyHistories()
        assertThat(propertyHistoriesA.size()).isEqualTo(0)

        configurationService.updateProperty(name, value2)

        final List<PropertyHistory> propertyHistoriesB = configurationHistoryService.findAllPropertyHistories()
        assertThat(propertyHistoriesB.size()).isEqualTo(1)

        final PropertyHistory propertyHistoryB0 = propertyHistoriesB.get(0)
        assertThat(propertyHistoryB0.getCode()).isEqualTo(code)
        assertThat(propertyHistoryB0.getPreviousValue()).isEqualTo(value1)
        assertThat(propertyHistoryB0.getCurrentValue()).isEqualTo(value2)

        configurationService.updateProperty(name, value3)

        final List<PropertyHistory> propertyHistoriesC = configurationHistoryService.findAllPropertyHistories()
        assertThat(propertyHistoriesC.size()).isEqualTo(2)

        final PropertyHistory propertyHistoryC0 = propertyHistoriesC.get(0)
        assertThat(propertyHistoryC0.getCode()).isEqualTo(code)
        assertThat(propertyHistoryC0.getPreviousValue()).isEqualTo(value1)
        assertThat(propertyHistoryC0.getCurrentValue()).isEqualTo(value2)

        final PropertyHistory propertyHistoryC1 = propertyHistoriesC.get(1)
        assertThat(propertyHistoryC1.getCode()).isEqualTo(code)
        assertThat(propertyHistoryC1.getPreviousValue()).isEqualTo(value2)
        assertThat(propertyHistoryC1.getCurrentValue()).isEqualTo(value3)
    }

    @Test
    void findAllHistory2Test() {
        final Code code = Code.EXAMPLE_BOOLEAN_PROPERTY
        final String name = "EXAMPLE_BOOLEAN_PROPERTY"
        final String value1 = "true"
        final String value2 = "false"
        final String value3 = "true"

        final List<PropertyHistory> propertyHistoriesA = configurationHistoryService.findAllPropertyHistories()
        assertThat(propertyHistoriesA.size()).isEqualTo(0)

        configurationService.updateProperty(name, value2)

        final List<PropertyHistory> propertyHistoriesB = configurationHistoryService.findAllPropertyHistories()
        assertThat(propertyHistoriesB.size()).isEqualTo(1)

        final PropertyHistory propertyHistoryB0 = propertyHistoriesB.get(0)
        assertThat(propertyHistoryB0.getCode()).isEqualTo(code)
        assertThat(propertyHistoryB0.getPreviousValue()).isEqualTo(value1)
        assertThat(propertyHistoryB0.getCurrentValue()).isEqualTo(value2)

        configurationService.updateProperty(name, value3)

        final List<PropertyHistory> propertyHistoriesC = configurationHistoryService.findAllPropertyHistories()
        assertThat(propertyHistoriesC.size()).isEqualTo(2)

        final PropertyHistory propertyHistoryC0 = propertyHistoriesC.get(0)
        assertThat(propertyHistoryC0.getCode()).isEqualTo(code)
        assertThat(propertyHistoryC0.getPreviousValue()).isEqualTo(value1)
        assertThat(propertyHistoryC0.getCurrentValue()).isEqualTo(value2)

        final PropertyHistory propertyHistoryC1 = propertyHistoriesC.get(1)
        assertThat(propertyHistoryC1.getCode()).isEqualTo(code)
        assertThat(propertyHistoryC1.getPreviousValue()).isEqualTo(value2)
        assertThat(propertyHistoryC1.getCurrentValue()).isEqualTo(value3)
    }

    @Test
    void findAllHistory3Test() {
        final Code code = Code.EXAMPLE_STRING_PROPERTY
        final String name = "EXAMPLE_STRING_PROPERTY"
        final String value1 = "one"
        final String value2 = "two"
        final String value3 = "three"

        final List<PropertyHistory> propertyHistoriesA = configurationHistoryService.findAllPropertyHistories()
        assertThat(propertyHistoriesA.size()).isEqualTo(0)

        configurationService.updateProperty(name, value2)

        final List<PropertyHistory> propertyHistoriesB = configurationHistoryService.findAllPropertyHistories()
        assertThat(propertyHistoriesB.size()).isEqualTo(1)

        final PropertyHistory propertyHistoryB0 = propertyHistoriesB.get(0)
        assertThat(propertyHistoryB0.getCode()).isEqualTo(code)
        assertThat(propertyHistoryB0.getPreviousValue()).isEqualTo(value1)
        assertThat(propertyHistoryB0.getCurrentValue()).isEqualTo(value2)

        configurationService.updateProperty(name, value3)

        final List<PropertyHistory> propertyHistoriesC = configurationHistoryService.findAllPropertyHistories()
        assertThat(propertyHistoriesC.size()).isEqualTo(2)

        final PropertyHistory propertyHistoryC0 = propertyHistoriesC.get(0)
        assertThat(propertyHistoryC0.getCode()).isEqualTo(code)
        assertThat(propertyHistoryC0.getPreviousValue()).isEqualTo(value1)
        assertThat(propertyHistoryC0.getCurrentValue()).isEqualTo(value2)

        final PropertyHistory propertyHistoryC1 = propertyHistoriesC.get(1)
        assertThat(propertyHistoryC1.getCode()).isEqualTo(code)
        assertThat(propertyHistoryC1.getPreviousValue()).isEqualTo(value2)
        assertThat(propertyHistoryC1.getCurrentValue()).isEqualTo(value3)
    }

    @Test
    void findAllHistory4Test() {
        final Code code = Code.EXAMPLE_INTEGER_PROPERTY
        final String name = "EXAMPLE_INTEGER_PROPERTY"
        final String value1 = "1"
        final String value2 = "2"
        final String value3 = "3"

        final List<PropertyHistory> propertyHistoriesA = configurationHistoryService.findAllPropertyHistories()
        assertThat(propertyHistoriesA.size()).isEqualTo(0)

        configurationService.updateProperty(name, value2)

        final List<PropertyHistory> propertyHistoriesB = configurationHistoryService.findAllPropertyHistories()
        assertThat(propertyHistoriesB.size()).isEqualTo(1)

        final PropertyHistory propertyHistoryB0 = propertyHistoriesB.get(0)
        assertThat(propertyHistoryB0.getCode()).isEqualTo(code)
        assertThat(propertyHistoryB0.getPreviousValue()).isEqualTo(value1)
        assertThat(propertyHistoryB0.getCurrentValue()).isEqualTo(value2)

        configurationService.updateProperty(name, value3)

        final List<PropertyHistory> propertyHistoriesC = configurationHistoryService.findAllPropertyHistories()
        assertThat(propertyHistoriesC.size()).isEqualTo(2)

        final PropertyHistory propertyHistoryC0 = propertyHistoriesC.get(0)
        assertThat(propertyHistoryC0.getCode()).isEqualTo(code)
        assertThat(propertyHistoryC0.getPreviousValue()).isEqualTo(value1)
        assertThat(propertyHistoryC0.getCurrentValue()).isEqualTo(value2)

        final PropertyHistory propertyHistoryC1 = propertyHistoriesC.get(1)
        assertThat(propertyHistoryC1.getCode()).isEqualTo(code)
        assertThat(propertyHistoryC1.getPreviousValue()).isEqualTo(value2)
        assertThat(propertyHistoryC1.getCurrentValue()).isEqualTo(value3)
    }
}
