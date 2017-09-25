package demo

import demo.service.core.Code
import demo.service.{ConfigurationHistoryService, ConfigurationService}
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(classOf[SpringRunner])
@SpringBootTest
@Transactional
class PropertyHistoryServiceTest {

  @Autowired
  private val configurationService: ConfigurationService = null

  @Autowired
  private val configurationHistoryService: ConfigurationHistoryService = null

  @Test
  def findAllHistory1Test() {
    val code = Code.EXAMPLE_ENUM_PROPERTY
    val name = "EXAMPLE_ENUM_PROPERTY"
    val value1 = "ONE"
    val value2 = "TWO"
    val value3 = "THREE"

    val propertyHistoriesA = configurationHistoryService.findAllPropertyHistories()
    assertThat(propertyHistoriesA.size).isEqualTo(0)

    configurationService.updateProperty(name, value2)

    val propertyHistoriesB = configurationHistoryService.findAllPropertyHistories()
    assertThat(propertyHistoriesB.size).isEqualTo(1)

    val propertyHistoryB0 = propertyHistoriesB.get(0)
    assertThat(propertyHistoryB0.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(code)
    assertThat(propertyHistoryB0.previousValue).isEqualTo(value1)
    assertThat(propertyHistoryB0.currentValue).isEqualTo(value2)

    configurationService.updateProperty(name, value3)

    val propertyHistoriesC = configurationHistoryService.findAllPropertyHistories()
    assertThat(propertyHistoriesC.size).isEqualTo(2)

    val propertyHistoryC0 = propertyHistoriesC.get(0)
    assertThat(propertyHistoryC0.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(code)
    assertThat(propertyHistoryC0.previousValue).isEqualTo(value1)
    assertThat(propertyHistoryC0.currentValue).isEqualTo(value2)

    val propertyHistoryC1 = propertyHistoriesC.get(1)
    assertThat(propertyHistoryC1.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(code)
    assertThat(propertyHistoryC1.previousValue).isEqualTo(value2)
    assertThat(propertyHistoryC1.currentValue).isEqualTo(value3)
  }

  @Test
  def findAllHistory2Test() {
    val code = Code.EXAMPLE_BOOLEAN_PROPERTY
    val name = "EXAMPLE_BOOLEAN_PROPERTY"
    val value1 = "true"
    val value2 = "false"
    val value3 = "true"

    val propertyHistoriesA = configurationHistoryService.findAllPropertyHistories()
    assertThat(propertyHistoriesA.size).isEqualTo(0)

    configurationService.updateProperty(name, value2)

    val propertyHistoriesB = configurationHistoryService.findAllPropertyHistories()
    assertThat(propertyHistoriesB.size).isEqualTo(1)

    val propertyHistoryB0 = propertyHistoriesB.get(0)
    assertThat(propertyHistoryB0.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(code)
    assertThat(propertyHistoryB0.previousValue).isEqualTo(value1)
    assertThat(propertyHistoryB0.currentValue).isEqualTo(value2)

    configurationService.updateProperty(name, value3)

    val propertyHistoriesC = configurationHistoryService.findAllPropertyHistories()
    assertThat(propertyHistoriesC.size).isEqualTo(2)

    val propertyHistoryC0 = propertyHistoriesC.get(0)
    assertThat(propertyHistoryC0.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(code)
    assertThat(propertyHistoryC0.previousValue).isEqualTo(value1)
    assertThat(propertyHistoryC0.currentValue).isEqualTo(value2)

    val propertyHistoryC1 = propertyHistoriesC.get(1)
    assertThat(propertyHistoryC1.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(code)
    assertThat(propertyHistoryC1.previousValue).isEqualTo(value2)
    assertThat(propertyHistoryC1.currentValue).isEqualTo(value3)
  }

  @Test
  def findAllHistory3Test() {
    val code = Code.EXAMPLE_STRING_PROPERTY
    val name = "EXAMPLE_STRING_PROPERTY"
    val value1 = "one"
    val value2 = "two"
    val value3 = "three"

    val propertyHistoriesA = configurationHistoryService.findAllPropertyHistories()
    assertThat(propertyHistoriesA.size).isEqualTo(0)

    configurationService.updateProperty(name, value2)

    val propertyHistoriesB = configurationHistoryService.findAllPropertyHistories()
    assertThat(propertyHistoriesB.size).isEqualTo(1)

    val propertyHistoryB0 = propertyHistoriesB.get(0)
    assertThat(propertyHistoryB0.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(code)
    assertThat(propertyHistoryB0.previousValue).isEqualTo(value1)
    assertThat(propertyHistoryB0.currentValue).isEqualTo(value2)

    configurationService.updateProperty(name, value3)

    val propertyHistoriesC = configurationHistoryService.findAllPropertyHistories()
    assertThat(propertyHistoriesC.size).isEqualTo(2)

    val propertyHistoryC0 = propertyHistoriesC.get(0)
    assertThat(propertyHistoryC0.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(code)
    assertThat(propertyHistoryC0.previousValue).isEqualTo(value1)
    assertThat(propertyHistoryC0.currentValue).isEqualTo(value2)

    val propertyHistoryC1 = propertyHistoriesC.get(1)
    assertThat(propertyHistoryC1.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(code)
    assertThat(propertyHistoryC1.previousValue).isEqualTo(value2)
    assertThat(propertyHistoryC1.currentValue).isEqualTo(value3)
  }

  @Test
  def findAllHistory4Test() {
    val code = Code.EXAMPLE_INTEGER_PROPERTY
    val name = "EXAMPLE_INTEGER_PROPERTY"
    val value1 = "1"
    val value2 = "2"
    val value3 = "3"

    val propertyHistoriesA = configurationHistoryService.findAllPropertyHistories()
    assertThat(propertyHistoriesA.size).isEqualTo(0)

    configurationService.updateProperty(name, value2)

    val propertyHistoriesB = configurationHistoryService.findAllPropertyHistories()
    assertThat(propertyHistoriesB.size).isEqualTo(1)

    val propertyHistoryB0 = propertyHistoriesB.get(0)
    assertThat(propertyHistoryB0.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(code)
    assertThat(propertyHistoryB0.previousValue).isEqualTo(value1)
    assertThat(propertyHistoryB0.currentValue).isEqualTo(value2)

    configurationService.updateProperty(name, value3)

    val propertyHistoriesC = configurationHistoryService.findAllPropertyHistories()
    assertThat(propertyHistoriesC.size).isEqualTo(2)

    val propertyHistoryC0 = propertyHistoriesC.get(0)
    assertThat(propertyHistoryC0.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(code)
    assertThat(propertyHistoryC0.previousValue).isEqualTo(value1)
    assertThat(propertyHistoryC0.currentValue).isEqualTo(value2)

    val propertyHistoryC1 = propertyHistoriesC.get(1)
    assertThat(propertyHistoryC1.code.asInstanceOf[Ordered[Code.Code]]).isEqualTo(code)
    assertThat(propertyHistoryC1.previousValue).isEqualTo(value2)
    assertThat(propertyHistoryC1.currentValue).isEqualTo(value3)
  }
}
