package demo.repository

import demo.domain.Property
import demo.service.core.Code
import org.springframework.data.jpa.repository.JpaRepository

interface PropertyRepository extends JpaRepository<Property, Code> {

    Optional<Property> findByCode(Code code)
}
