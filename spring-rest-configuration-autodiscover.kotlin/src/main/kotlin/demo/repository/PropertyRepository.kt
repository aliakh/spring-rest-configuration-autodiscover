package demo.repository

import demo.domain.Property
import demo.service.core.Code
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PropertyRepository : JpaRepository<Property, Code> {

    fun findByCode(code: Code): Optional<Property>
}
