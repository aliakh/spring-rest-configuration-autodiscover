package demo.service.core

import java.util.stream.Collectors
import java.util.stream.Stream

abstract class PropertyEnumService<T extends Enum<T>> extends AbstractPropertyService<T> {

    @Override
    Type getType() {
        return Type.ENUM
    }

    @Override
    T fromString(String input) {
        return input == null ? getDefaultValue() : Enum.valueOf(getEnumClass(), input)
    }

    @Override
    String toString(T input) {
        return (input == null) ? getDefaultValue().toString() : String.valueOf(input)
    }

    @Override
    List<String> getPossibleValues() {
        return Stream.of(getEnumClass().getEnumConstants()).map(Enum::name).collect(Collectors.toList())
    }

    protected abstract Class<T> getEnumClass()
}
