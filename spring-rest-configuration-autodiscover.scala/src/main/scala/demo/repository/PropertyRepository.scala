package demo.repository

import java.util.Optional

import demo.domain.Property
import demo.service.core.Code
import org.springframework.data.jpa.repository.JpaRepository

trait PropertyRepository extends JpaRepository[Property, Code.Value] {

  def findByCode(code: Code.Value): Optional[Property]
}
