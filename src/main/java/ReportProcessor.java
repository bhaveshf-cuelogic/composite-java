import java.util.HashMap;
import java.util.Map;

public class ReportProcessor implements TypeProcessor {
    public interface Handler{
        String handle(TypeBase type);
    }
    private static Map<Class<?>, Handler> registry = new HashMap<>();
    public static void register(Class<?>clazz, Handler handle){
        registry.put(clazz, handle);
    }

    static {
        registry.put(CompositeType.class, type -> " composite type data to fetch");
        registry.put(Type.class, type -> " type data to fetch");
    }

    private String report = "";
    private String indent = "";

    @Override
    public void process(TypeBase type) {
        report += indent + type.getName() + ":";
        Handler handler =  registry.get(type.getClass());
        report += handler.handle(type) + "\n";
    }

    public String getReport(){
        return report;
    }
}
