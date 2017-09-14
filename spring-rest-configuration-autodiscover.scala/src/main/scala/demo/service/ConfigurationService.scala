package demo.service

import java.util._

import demo.domain.Property
import demo.repository.PropertyRepository
import demo.service.core.Code
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ConfigurationService {

  @Autowired
  private val propertyRepository: PropertyRepository = null

  @Autowired
  private val configurationHistoryService: ConfigurationHistoryService = null

  @Autowired
  private val registerService: RegisterService = null

  def findAllProperties(): java.util.List[Property] =
    propertyRepository.findAll()
      .stream()
      .map[Property](property => this.addPossibleValues(property))
      .collect(java.util.stream.Collectors.toList[Property])

  def findPropertyByName(name: String): Optional[Property] = {
    propertyRepository.findByCode(Code.withName(name))
      .map { property => this.addPossibleValues(property) }
  }

  private def addPossibleValues(property: Property): Property = {
    val propertyService = registerService.findPropertyServiceByCode(property.code)
    property.addPossibleValues(propertyService.getPossibleValues)
  }

  @Transactional
  def updateProperty(name: String, value: String): Property = {
    val propertyOpt = propertyRepository.findByCode(Code.withName(name))
    if (!propertyOpt.isPresent) {
      throw new RuntimeException("Property not found by name: " + name)
    }

    val property = propertyOpt.get()
    val code = property.code

    configurationHistoryService.savePropertyHistory(code, property.value, value)

    val propertyService = registerService.findPropertyServiceByCode(code)
    propertyService.update(value)
  }
}
