package demo.domain

import java.time.LocalDateTime
import javax.persistence._

import demo.service.core.Code

@Entity
class PropertyHistory {

  @Id
  @GeneratedValue
  var id: Long = _

  @Column(nullable = false)
  var createDate: LocalDateTime = _

  @Column(nullable = false)
  @Enumerated(value = EnumType.STRING)
  var code: Code.Value = _

  @Column(nullable = false)
  var previousValue: String = _

  @Column(nullable = false)
  var currentValue: String = _
}
