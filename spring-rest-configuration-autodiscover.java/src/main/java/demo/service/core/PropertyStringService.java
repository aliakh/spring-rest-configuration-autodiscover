package demo.service.core;

public abstract class PropertyStringService extends AbstractPropertyService<String> {

    @Override
    public Type getType() {
        return Type.STRING;
    }

    @Override
    public String fromString(String input) {
        return input == null ? getDefaultValue() : input;
    }

    @Override
    public String toString(String input) {
        return (input == null) ? getDefaultValue() : input;
    }
}
