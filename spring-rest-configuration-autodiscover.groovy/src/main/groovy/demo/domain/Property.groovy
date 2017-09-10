package demo.domain

import demo.service.core.Code
import demo.service.core.Type

import javax.persistence.*

@Entity
class Property {

    @Id
    @Enumerated(value = EnumType.STRING)
    private Code code

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Type type

    @Column(nullable = false)
    private String value

    @Transient
    private List<String> possibleValues = new ArrayList<>()

    Code getCode() {
        return code
    }

    void setCode(Code code) {
        this.code = code
    }

    Type getType() {
        return type
    }

    void setType(Type type) {
        this.type = type
    }

    String getValue() {
        return value
    }

    void setValue(String value) {
        this.value = value
    }

    List<String> getPossibleValues() {
        return possibleValues
    }

    void setPossibleValues(List<String> possibleValues) {
        this.possibleValues = possibleValues
    }

    Property addPossibleValues(List<String> possibleValues) {
        this.possibleValues = possibleValues
        return this
    }
}

