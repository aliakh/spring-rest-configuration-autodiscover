package demo.service

import demo.service.core.Code
import demo.service.core.PropertyService
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.PostConstruct

@Service
class RegisterService {

    private val LOGGER = LogFactory.getLog(RegisterService::class.java)

    @Autowired
    private val propertyServices: List<PropertyService<*>>? = null

    private val codeToPropertyService = EnumMap<Code, PropertyService<*>>(Code::class.java)

    @PostConstruct
    fun init() {
        LOGGER.info("Property services count: " + propertyServices!!.size)

        for (propertyService in propertyServices.orEmpty()) {
            val code = propertyService.getCode()
            LOGGER.info(String.format("Property service %s is registering by the code %s", propertyService.javaClass.simpleName, code))

            val propertyService0 = codeToPropertyService[code]
            if (propertyService0 != null) {
                throw RuntimeException(String.format("Property service %s is already registered by the code %s", propertyService0, code))
            }

            codeToPropertyService.put(code, propertyService)
            propertyService.init()
        }
    }

    fun findPropertyServiceByCode(code: Code): PropertyService<*> {
        return codeToPropertyService[code] ?: throw RuntimeException("Property service not found by the code: " + code)
    }
}
