package demo.repository;

import demo.domain.Property;
import demo.service.core.Code;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property, Code> {

    Optional<Property> findByCode(Code code);
}
