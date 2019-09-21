public class ConcreteVisitor implements EmployeeVisitor{

    @Override
    public void visit(Employee employee) {
        System.out.println("employee called");
    }

    @Override
    public void visit(CompositeEmployee employee) {
        System.out.println("composite employee called");
    }

    @Override
    public void visit(Manager employee) {
        System.out.println("manager called");
    }

    @Override
    public void visit(Worker employee) {
        System.out.println("worker called");
    }

}
