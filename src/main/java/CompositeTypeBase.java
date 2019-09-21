import java.util.ArrayList;
import java.util.List;

public abstract class CompositeTypeBase extends TypeBase {
    private List<TypeBase> subTypes = new ArrayList<TypeBase>();

    public CompositeTypeBase(String name){
        super(name);
    }

    public List<TypeBase> getSubTypes(){
        return subTypes;
    }

    public CompositeTypeBase add(TypeBase minion){
        subTypes.add(minion);
        return this;
    }

    public void useProcessor(TypeProcessor visitor){
        visitor.process(this);
        subTypes.stream().forEach(minion-> minion.useProcessor(visitor));
    }
}

