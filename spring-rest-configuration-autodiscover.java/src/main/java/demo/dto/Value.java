package demo.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class Value {

    @NotEmpty
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
