public class Main {
    public static void main(String [ ] args)
    {

       CompositeEmployee prashant = new Manager("Prashant")
               .add(new Worker("bhavesh"))
               .add(new Worker("vallabh"))
               .add(new Worker("david"));
       CompositeEmployee hrishi = new Manager("Hrishi")
                .add(new Worker("rahul"))
                .add(new Worker("prasana"))
                .add(new Worker("bhagwan"));
        CompositeEmployee vivek = new Manager("Vivek")
                .add(hrishi).add(prashant);


        ReportProcessor visitor = new ReportProcessor();
        vivek.useProcessor(visitor);
        System.out.println(visitor.getReport());

    }
}