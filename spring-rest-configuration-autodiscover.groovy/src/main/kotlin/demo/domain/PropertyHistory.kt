package demo.domain

import demo.service.core.Code
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class PropertyHistory {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(nullable = false)
    var createDate: LocalDateTime? = null

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    var code: Code? = null

    @Column(nullable = false)
    var previousValue: String? = null

    @Column(nullable = false)
    var currentValue: String? = null
}
