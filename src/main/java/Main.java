public class Main {
    public static void main(String [ ] args)
    {
       CompositeTypeBase enrollment = new CompositeType("Enrollment")
               .add(new Type("SSN"))
               .add(new CompositeType("Address")
                       .add(new Type("State"))
                       .add(new Type("City")));

        ReportProcessor visitor = new ReportProcessor();
        enrollment.useProcessor(visitor);
        System.out.println(visitor.getReport());

    }
}