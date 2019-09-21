public interface EmployeeVisitor {
  void visit(Employee employee);
  void visit(CompositeEmployee employee);
  void visit(Manager employee);
  void visit(Worker employee);
}
