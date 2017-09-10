package demo.service

import demo.service.core.Code
import demo.service.core.PropertyService
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct

@Service
class RegisterService {

    private static final Log LOGGER = LogFactory.getLog(RegisterService.class)

    @Autowired
    private List<? extends PropertyService> propertyServices

    private final Map<Code, PropertyService<?>> codeToPropertyService = new EnumMap<>(Code.class)

    @PostConstruct
    void init() {
        LOGGER.info("Property services count: " + propertyServices.size())

        for (PropertyService propertyService : propertyServices) {
            Code code = propertyService.getCode()
            LOGGER.info(String.format("Property service %s is registering by the code %s", propertyService.getClass().getSimpleName(), code))

            PropertyService<?> propertyService0 = codeToPropertyService.get(code)
            if (propertyService0 != null) {
                throw new RuntimeException(String.format("Property service %s is already registered by the code %s", propertyService0, code))
            }

            codeToPropertyService.put(code, propertyService)
            propertyService.init()
        }
    }

    PropertyService<?> findPropertyServiceByCode(Code code) {
        PropertyService<?> propertyService = codeToPropertyService.get(code)
        if (propertyService == null) {
            throw new RuntimeException("Property service not found by the code: " + code)
        }
        return propertyService
    }
}
