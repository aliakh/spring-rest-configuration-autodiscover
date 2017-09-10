package demo.domain;

import demo.service.core.Code;
import demo.service.core.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Property {

    @Id
    @Enumerated(value = EnumType.STRING)
    private Code code;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    private String value;

    @Transient
    private List<String> possibleValues = new ArrayList<>();

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(List<String> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public Property addPossibleValues(List<String> possibleValues) {
        this.possibleValues = possibleValues;
        return this;
    }
}

