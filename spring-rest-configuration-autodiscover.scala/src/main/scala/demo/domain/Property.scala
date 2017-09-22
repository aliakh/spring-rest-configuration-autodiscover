package demo.domain

import javax.persistence._

import demo.service.core.{Code, Type}

@Entity
class Property {

  @Id
  @GeneratedValue
  var id: Long = _

  @Column(nullable = false)
  @Convert(converter = classOf[CodeConverter])
  var code: Code.Value = _

  @Column(nullable = false)
  @Convert(converter = classOf[TypeConverter])
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

