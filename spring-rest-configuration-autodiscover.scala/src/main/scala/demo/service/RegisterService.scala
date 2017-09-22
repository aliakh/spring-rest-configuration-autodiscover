package demo.service

import javax.annotation.PostConstruct

import demo.service.core.{Code, PropertyService}
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.collection.JavaConverters._

@Service
class RegisterService {

  private val LOGGER = LogFactory.getLog(classOf[RegisterService])

  @Autowired
  private val propertyServices: java.util.List[PropertyService[_]] = null

  private val codeToPropertyService = new java.util.HashMap[Code.Value, PropertyService[_]]()

  @PostConstruct
  def init() {
    LOGGER.info("Property services count: " + propertyServices.size)

    for (propertyService <- propertyServices.asScala) {
      val code = propertyService.getCode
      LOGGER.info(String.format("Property service %s is registering by the code %s", propertyService.getClass.getSimpleName, code))

      val propertyService0 = codeToPropertyService.get(code)
      if (propertyService0 != null) {
        throw new RuntimeException(String.format("Property service %s is already registered by the code %s", propertyService0, code))
      }

      codeToPropertyService.put(code, propertyService)
      propertyService.init()
    }
  }

  def findPropertyServiceByCode(code: Code.Value): PropertyService[_] = {
    val propertyService = codeToPropertyService.get(code)
    if (propertyService == null) {
      throw new RuntimeException("Property service not found by the code: " + code)
    }
    propertyService
  }
}
