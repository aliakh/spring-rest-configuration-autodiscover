package demo.dto

import org.hibernate.validator.constraints.NotEmpty

class Value {

    @NotEmpty
    private String value

    String getValue() {
        return value
    }

    void setValue(String value) {
        this.value = value
    }
}
