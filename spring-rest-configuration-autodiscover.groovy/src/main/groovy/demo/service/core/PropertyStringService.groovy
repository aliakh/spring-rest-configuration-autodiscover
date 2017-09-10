package demo.service.core

abstract class PropertyStringService extends AbstractPropertyService<String> {

    @Override
    Type getType() {
        return Type.STRING
    }

    @Override
    String fromString(String input) {
        return input == null ? getDefaultValue() : input
    }

    @Override
    String toString(String input) {
        return (input == null) ? getDefaultValue() : input
    }
}
