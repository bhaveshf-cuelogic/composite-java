public abstract class TypeBase {
    private String name;

    public String getName() {
        return name;
    }

    public TypeBase(String name){
        this.name = name;
    }

    public void useProcessor(TypeProcessor visitor) {
        visitor.process(this);
    }

}
