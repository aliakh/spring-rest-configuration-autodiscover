package demo.service.core

import demo.domain.Property

interface PropertyService<T> {

    Property update(String value)

    void init()

    Code getCode()

    List<String> getPossibleValues()
}
