package demo.controller

import demo.domain.Property
import demo.domain.PropertyHistory
import demo.dto.Value
import demo.service.ConfigurationHistoryService
import demo.service.ConfigurationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation._
import javax.validation.Valid

@RestController
@RequestMapping(value = "api/configuration", produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
class ConfigurationController {

    @Autowired
    private val configurationService: ConfigurationService? = null

    @Autowired
    private val configurationHistoryService: ConfigurationHistoryService? = null

    @RequestMapping(value = "", method = arrayOf(RequestMethod.GET))
    def findAllProperties(): ResponseEntity<List<Property>> {
        return ResponseEntity(configurationService.findAllProperties(), HttpStatus.OK)
    }

    @RequestMapping(value = "/name/{name}", method = arrayOf(RequestMethod.GET))
    def findPropertyByName(
            @PathVariable name: String): ResponseEntity<Property> {
        val propertyOpt = configurationService.findPropertyByName(name)
        return propertyOpt
                .map<ResponseEntity<Property>>({ property -> ResponseEntity(property, HttpStatus.OK) })
                .orElseGet { ResponseEntity(Property(), HttpStatus.NOT_FOUND) }
    }

    @RequestMapping(value = "/name/{name}", method = arrayOf(RequestMethod.PUT), consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    def updateProperty(
            @PathVariable name: String,
            @Valid @RequestBody value: Value): ResponseEntity<Property> {
        return ResponseEntity(configurationService.updateProperty(name, value.value!!), HttpStatus.OK)
    }

    @RequestMapping(value = "/history", method = arrayOf(RequestMethod.GET))
    def findAllPropertyHistories(): List<PropertyHistory> {
        return configurationHistoryService.findAllPropertyHistories()
    }
}
