import java.util.ArrayList;
import java.util.List;

public abstract class CompositeEmployee extends  Employee{
    private List<Employee> minions = new ArrayList<Employee>();

    public CompositeEmployee(String name){
        super(name);
    }

    public List<Employee> getMinions(){
        return minions;
    }

    public CompositeEmployee add(Employee minion){
        minions.add(minion);
        return this;
    }

    protected void acceptChildren(EmployeeVisitor visitor){
        minions.stream().forEach(minion-> minion.accept(visitor));
    }
    public void accept(EmployeeVisitor visitor){
        visitor.visit(this);
        acceptChildren(visitor);
    }

    public void useProcessor(EmployeeProcessor visitor){
        visitor.process(this);
        minions.stream().forEach(minion-> minion.useProcessor(visitor));
    }
}

