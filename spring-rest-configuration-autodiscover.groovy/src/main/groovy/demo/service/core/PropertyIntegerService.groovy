package demo.service.core

abstract class PropertyIntegerService extends AbstractPropertyService<Integer> {

    @Override
    Type getType() {
        return Type.INTEGER
    }

    @Override
    Integer fromString(String input) {
        return input == null ? getDefaultValue() : Integer.valueOf(input)
    }

    @Override
    String toString(Integer input) {
        return (input == null) ? getDefaultValue().toString() : String.valueOf(input)
    }
}
