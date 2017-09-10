package demo.service

import demo.domain.PropertyHistory
import demo.repository.PropertyHistoryRepository
import demo.service.core.Code
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.time.LocalDateTime

@Service
class ConfigurationHistoryService {

    private static final Log LOGGER = LogFactory.getLog(ConfigurationHistoryService.class)

    @Autowired
    private PropertyHistoryRepository propertyHistoryRepository

    void save(Code code, String previousValue, String currentValue) {
        LOGGER.info(String.format("Property %s is changing from '%s' to '%s'", code, previousValue, currentValue))

        PropertyHistory propertyHistory = new PropertyHistory()
        propertyHistory.setCreateDate(LocalDateTime.now())
        propertyHistory.setCode(code)
        propertyHistory.setPreviousValue(previousValue)
        propertyHistory.setCurrentValue(currentValue)

        propertyHistoryRepository.save(propertyHistory)
    }

    List<PropertyHistory> findAllPropertyHistories() {
        return propertyHistoryRepository.findAll()
    }
}
