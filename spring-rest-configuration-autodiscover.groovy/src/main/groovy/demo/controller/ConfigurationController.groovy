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
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping(value = "api/configuration", produces = MediaType.APPLICATION_JSON_VALUE)
class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService

    @Autowired
    private ConfigurationHistoryService configurationHistoryService

    @RequestMapping(value = "", method = RequestMethod.GET)
    ResponseEntity<List<Property>> findAllProperties() {
        return new ResponseEntity<>(configurationService.findAllProperties(), HttpStatus.OK)
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    ResponseEntity<Property> findPropertyByName(
            @PathVariable String name) {
        Optional<Property> propertyOpt = configurationService.findPropertyByName(name)
        return propertyOpt
                .map(configuration -> new ResponseEntity<>(configuration, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new Property(), HttpStatus.NOT_FOUND))
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Property> updateProperty(
            @PathVariable String name,
            @Valid @RequestBody Value value) {
        return new ResponseEntity<>(configurationService.updateProperty(name, value.getValue()), HttpStatus.OK)
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    List<PropertyHistory> findAllPropertyHistories() {
        return configurationHistoryService.findAllPropertyHistories()
    }
}
