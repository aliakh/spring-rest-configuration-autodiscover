package demo.service.core

abstract class PropertyBooleanService extends AbstractPropertyService<Boolean> {

    @Override
    Type getType() {
        return Type.BOOLEAN
    }

    @Override
    Boolean fromString(String input) {
        return input == null ? getDefaultValue() : Boolean.valueOf(input)
    }

    @Override
    String toString(Boolean input) {
        return (input == null) ? getDefaultValue().toString() : String.valueOf(input)
    }

    List<String> getPossibleValues() {
        return Arrays.asList("true", "false")
    }
}
