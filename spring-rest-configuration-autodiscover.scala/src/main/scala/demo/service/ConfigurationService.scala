package demo.service

import demo.domain.Property
import demo.repository.PropertyRepository
import demo.service.core.Code
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ConfigurationService {

    @Autowired
    private val propertyRepository: PropertyRepository? = null

    @Autowired
    private val configurationHistoryService: ConfigurationHistoryService? = null

    @Autowired
    private val registerService: RegisterService? = null

    def findAllProperties(): List<Property> {
        return propertyRepository.findAll()
                .map { property -> this.addPossibleValues(property) }
    }

    def findPropertyByName(name: String): Optional<Property> {
        return propertyRepository.findByCode(Code.valueOf(name))
                .map { property -> this.addPossibleValues(property) }
    }

    private def addPossibleValues(property: Property): Property {
        val propertyService = registerService.findPropertyServiceByCode(property.code!!)
        return property.addPossibleValues(propertyService.getPossibleValues())
    }

    @Transactional
    def updateProperty(name: String, value: String): Property {
        val propertyOpt = propertyRepository.findByCode(Code.valueOf(name))
        if (!propertyOpt.isPresent) {
            throw RuntimeException("Property not found by name: " + name)
        }

        val property = propertyOpt.get()
        val code = property.code!!

        configurationHistoryService.savePropertyHistory(code, property.value!!, value)

        val propertyService = registerService.findPropertyServiceByCode(code)
        return propertyService.update(value)
    }
}
