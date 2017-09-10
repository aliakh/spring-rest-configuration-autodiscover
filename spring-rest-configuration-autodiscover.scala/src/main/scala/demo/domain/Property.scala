package demo.domain

import demo.service.core.Code
import demo.service.core.Type
import java.util.*
import javax.persistence.*

@Entity
class Property {

    @Id
    @Enumerated(value = EnumType.STRING)
    var code: Code? = null

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    var type: Type? = null

    @Column(nullable = false)
    var value: String? = null

    @Transient
    var possibleValues: List<String> = ArrayList()

    def addPossibleValues(possibleValues: List<String>): Property {
        this.possibleValues = possibleValues
        return this
    }
}

