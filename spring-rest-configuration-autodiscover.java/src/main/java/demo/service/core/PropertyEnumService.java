package demo.service.core;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class PropertyEnumService<T extends Enum<T>> extends AbstractPropertyService<T> {

    @Override
    public Type getType() {
        return Type.ENUM;
    }

    @Override
    public T fromString(String input) {
        return input == null ? getDefaultValue() : Enum.valueOf(getEnumClass(), input);
    }

    @Override
    public String toString(T input) {
        return (input == null) ? getDefaultValue().toString() : String.valueOf(input);
    }

    @Override
    public List<String> getPossibleValues() {
        return Stream.of(getEnumClass().getEnumConstants()).map(Enum::name).collect(Collectors.toList());
    }

    protected abstract Class<T> getEnumClass();
}
