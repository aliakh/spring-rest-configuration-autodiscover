package demo.service.core;

import demo.domain.Property;

import java.util.List;

public interface PropertyService<T> {

    Property update(String value);

    void init();

    Code getCode();

    List<String> getPossibleValues();
}
