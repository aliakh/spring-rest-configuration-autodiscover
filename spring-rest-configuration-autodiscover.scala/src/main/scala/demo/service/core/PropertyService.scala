package demo.service.core

import demo.domain.Property

interface PropertyService<T> {

    def update(value: String): Property

    def init()

    def getCode(): Code

    def getPossibleValues(): List<String>
}
