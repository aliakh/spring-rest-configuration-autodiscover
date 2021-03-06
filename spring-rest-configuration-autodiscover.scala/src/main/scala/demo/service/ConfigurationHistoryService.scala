package demo.service

import java.time.LocalDateTime

import demo.domain.PropertyHistory
import demo.repository.PropertyHistoryRepository
import demo.service.core.Code
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ConfigurationHistoryService {

  private val LOGGER = LogFactory.getLog(classOf[ConfigurationHistoryService])

  @Autowired
  private val propertyHistoryRepository: PropertyHistoryRepository = null

  def savePropertyHistory(code: Code.Value, previousValue: String, currentValue: String) {
    LOGGER.info(String.format("Property %s is changing from '%s' to '%s'", code, previousValue, currentValue))

    val propertyHistory = new PropertyHistory()
    propertyHistory.createDate = LocalDateTime.now()
    propertyHistory.code = code
    propertyHistory.previousValue = previousValue
    propertyHistory.currentValue = currentValue

    propertyHistoryRepository.save(propertyHistory)
  }

  def findAllPropertyHistories(): java.util.List[PropertyHistory] = {
    propertyHistoryRepository.findAll()
  }
}
