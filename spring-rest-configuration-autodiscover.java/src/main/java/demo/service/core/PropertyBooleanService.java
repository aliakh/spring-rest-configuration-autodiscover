package demo.service.core;

import java.util.Arrays;
import java.util.List;

public abstract class PropertyBooleanService extends AbstractPropertyService<Boolean> {

    @Override
    public Type getType() {
        return Type.BOOLEAN;
    }

    @Override
    public Boolean fromString(String input) {
        return input == null ? getDefaultValue() : Boolean.valueOf(input);
    }

    @Override
    public String toString(Boolean input) {
        return (input == null) ? getDefaultValue().toString() : String.valueOf(input);
    }

    public List<String> getPossibleValues() {
        return Arrays.asList("true", "false");
    }
}
