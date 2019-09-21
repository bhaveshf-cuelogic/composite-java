public class ReportVisitor implements  EmployeeVisitor{
    private String report = "";

    @Override
    public void visit(Employee employee) {
        report+=employee.getName()+" employee\n";
    }

    @Override
    public void visit(CompositeEmployee employee) {
        report+=employee.getName()+" composite employee\n";
    }

    @Override
    public void visit(Manager employee) {
      report+=employee.getName()+" managing\n";
    }

    @Override
    public void visit(Worker employee) {
        report+=employee.getName()+" doing actual work\n";
    }

    public String getReport(){
        return  report;
    }
}
