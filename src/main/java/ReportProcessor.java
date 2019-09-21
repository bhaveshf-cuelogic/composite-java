import java.util.HashMap;
import java.util.Map;

public class ReportProcessor implements EmployeeProcessor{
    public interface Handler{
        String handle(Employee employee);
    }
    private static Map<Class<?>, Handler> registry = new HashMap<>();
    public static void register(Class<?>clazz, Handler handle){
        registry.put(clazz, handle);
    }

    static {
        registry.put(Manager.class, employee -> "telling people what to do");
        registry.put(Worker.class, employee -> "doing actual work");
    }

    private String report = "";
    private String indent = "";

    @Override
    public void process(Employee employee) {
        report += indent + employee.getName() + ":";
        Handler handler =  registry.get(employee.getClass());
        report += handler.handle(employee) + "\n";
    }

    public String getReport(){
        return report;
    }
}
