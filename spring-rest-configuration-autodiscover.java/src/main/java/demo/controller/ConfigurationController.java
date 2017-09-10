package demo.controller;

import demo.domain.Property;
import demo.domain.PropertyHistory;
import demo.dto.Value;
import demo.service.ConfigurationHistoryService;
import demo.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/configuration", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @Autowired
    private ConfigurationHistoryService configurationHistoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Property>> findAllProperties() {
        return new ResponseEntity<>(configurationService.findAllProperties(), HttpStatus.OK);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Property> findPropertyByName(
            @PathVariable String name) {
        Optional<Property> propertyOpt = configurationService.findPropertyByName(name);
        return propertyOpt
                .map(configuration -> new ResponseEntity<>(configuration, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new Property(), HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Property> updateProperty(
            @PathVariable String name,
            @Valid @RequestBody Value value) {
        return new ResponseEntity<>(configurationService.updateProperty(name, value.getValue()), HttpStatus.OK);
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public List<PropertyHistory> findAllPropertyHistories() {
        return configurationHistoryService.findAllPropertyHistories();
    }
}
