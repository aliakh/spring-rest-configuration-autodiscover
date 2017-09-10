package demo.service.core

import demo.domain.Property

interface PropertyService<T> {

    fun update(value: String): Property

    fun init()

    fun getCode(): Code

    fun getPossibleValues(): List<String>
}
