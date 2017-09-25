package demo.domain

import javax.persistence._

import demo.service.core.Code

class CodeIdClass extends Serializable {

  @Column(nullable = false)
  @Convert(converter = classOf[CodeConverter])
  var code: Code.Value = _
}
