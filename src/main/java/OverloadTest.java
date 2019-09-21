public class OverloadTest {


    public static void main(String [ ] args){
        EmployeeVisitor tester =new ConcreteVisitor();
        new Worker("test").accept(tester);
        new Manager("test1").accept(tester);
    }
}
