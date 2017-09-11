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
@RequestMapping(value = Array("api/configuration"), produces = Array(MediaType.APPLICATION_JSON_VALUE))
class ConfigurationController {

    @Autowired
    private val configurationService: ConfigurationService = _

    @Autowired
    private val configurationHistoryService: ConfigurationHistoryService = _

    @RequestMapping(value = Array(""), method = Array(RequestMethod.GET))
    def findAllProperties(): ResponseEntity[List[Property]] = {
        new ResponseEntity(configurationService.findAllProperties(), HttpStatus.OK)
    }

    @RequestMapping(value = Array("/name/{name}"), method = Array(RequestMethod.GET))
    def findPropertyByName(
            @PathVariable name: String): ResponseEntity[Property] = {
        val propertyOpt = configurationService.findPropertyByName(name)
        propertyOpt
                .map[ResponseEntity[Property]]({ property => new ResponseEntity(property, HttpStatus.OK) })
                .orElseGet { new ResponseEntity(new Property(), HttpStatus.NOT_FOUND) }
    }

    @RequestMapping(value = Array("/name/{name}"), method = Array(RequestMethod.PUT), consumes = Array(MediaType.APPLICATION_JSON_VALUE))
    def updateProperty(
            @PathVariable name: String,
            @Valid @RequestBody value: Value): ResponseEntity[Property] = {
        new ResponseEntity(configurationService.updateProperty(name, value.value), HttpStatus.OK)
    }

    @RequestMapping(value = Array("/history"), method = Array(RequestMethod.GET))
    def findAllPropertyHistories(): java.util.List[PropertyHistory] = {
        configurationHistoryService.findAllPropertyHistories()
    }
}
