package demo.service.core;

public abstract class PropertyIntegerService extends AbstractPropertyService<Integer> {

    @Override
    public Type getType() {
        return Type.INTEGER;
    }

    @Override
    public  Integer fromString(String input) {
        return input == null ? getDefaultValue() : Integer.valueOf(input);
    }

    @Override
    public  String toString(Integer input) {
        return (input == null) ? getDefaultValue().toString() : String.valueOf(input);
    }
}
