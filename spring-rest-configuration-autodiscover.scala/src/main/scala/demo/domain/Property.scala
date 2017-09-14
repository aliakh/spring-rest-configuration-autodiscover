package demo.domain

import javax.persistence._

import demo.service.core.{Code, Type}

@Entity
class Property {

  @Id
  @Enumerated(value = EnumType.STRING)
  var code: Code.Value = _

  @Column(nullable = false)
  @Enumerated(value = EnumType.STRING)
  var `type`: Type.Value = _

  @Column(nullable = false)
  var value: String = _

  @Transient
  var possibleValues: java.util.List[String] = new java.util.ArrayList()

  def addPossibleValues(possibleValues: java.util.List[String]): Property = {
    this.possibleValues = possibleValues
    this
  }
}

