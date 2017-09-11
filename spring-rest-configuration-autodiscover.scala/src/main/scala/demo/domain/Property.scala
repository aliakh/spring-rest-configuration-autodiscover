package demo.domain

import demo.service.core.Code
import demo.service.core.Type
import java.util._
import javax.persistence._

@Entity
class Property {

    @Id
    @Enumerated(value = EnumType.STRING)
    var code: Code.Value = _

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    var type: Type.Value = _

    @Column(nullable = false)
    var value: String = _

    @Transient
    var possibleValues: List[String] = new ArrayList()

    def addPossibleValues(possibleValues: List[String]): Property = {
        this.possibleValues = possibleValues
        this
    }
}

