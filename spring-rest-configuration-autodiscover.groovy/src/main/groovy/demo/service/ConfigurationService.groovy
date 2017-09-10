package demo.service

import demo.domain.Property
import demo.repository.PropertyRepository
import demo.service.core.Code
import demo.service.core.PropertyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import java.util.stream.Collectors

@Service
class ConfigurationService {

    @Autowired
    private PropertyRepository propertyRepository

    @Autowired
    private ConfigurationHistoryService configurationHistoryService

    @Autowired
    private RegisterService registerService

    List<Property> findAllProperties() {
        List<Property> properties = propertyRepository.findAll()
        return properties.stream()
                .map(this::addPossibleValues)
                .collect(Collectors.toList())
    }

    Optional<Property> findPropertyByName(String name) {
        Optional<Property> propertyOpt = propertyRepository.findByCode(Code.valueOf(name))
        return propertyOpt.map(this::addPossibleValues)
    }

    private Property addPossibleValues(Property property) {
        PropertyService<?> propertyService = registerService.findPropertyServiceByCode(property.getCode())
        return property.addPossibleValues(propertyService.getPossibleValues())
    }

    @Transactional
    Property updateProperty(String name, String value) {
        Optional<Property> configurationOpt = propertyRepository.findByCode(Code.valueOf(name))
        if (!configurationOpt.isPresent()) {
            throw new RuntimeException("Property not found by name: " + name)
        }

        Property property = configurationOpt.get()
        Code code = property.getCode()

        configurationHistoryService.save(code, property.getValue(), value)

        PropertyService<?> propertyService = registerService.findPropertyServiceByCode(code)
        return propertyService.update(value)
    }
}
