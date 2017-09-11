package demo.service.core

import demo.domain.Property

trait PropertyService[T] {

    def update(value: String): Property

    def init()

    def getCode: Code.Value

    def getPossibleValues: java.util.List[String]
}
