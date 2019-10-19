package demo.client;

import org.json.JSONException;
import org.json.JSONObject;

public class Test {
	public static void main(String[] args) throws JSONException {
		
		//String s = "{\"name\":\"bhavesh\",\"ssn\":\"ABC123\",\"phones\":[123,456],\"address\":{\"city\":\"Pune\"},\"hotels\":[{\"id\":1},{\"id\":2,\"name\":\"hotel2\"}]}";
		String s = "{'type':'Enrollment','data':[{'provider_id':1,'enrollment':{'name':{'firstName':'John','lastName':'Smith'},'roles':[{'id':{'testing':[{'name':'bhavesh','age':20}]}}],'address':{'name':'nik','phones':[987,7654]},'dob':'29/08/1991'}}]}";
		JSONObject js = new JSONObject(s);
//		JSONObject js = new JSONObject();
//		js.put("name", "bhavesh");
//		js.put("age", 30);
//		js.put("phones", new Object[]{"8050035172", 987});
//		js.put("address", new JSONObject().put("city", "Kalyan"));
//		js.put("office_address", new Object[] {new JSONObject().put("city", "Pune").put("state", "MH").put("zip", "421301")});
//		js.put("business_phones", new JSONObject().put("mumbai", new Object[] {987, 654}));
//		js.put("hotels", new Object[] {new JSONObject().put("id", 1), new JSONObject().put("id", 2).put("name", "Hilton")});
//		js.put("xyz", new JSONObject().put("address", new Object[] {new JSONObject().put("home_address", "Mumbai"), new JSONObject().put("business_address", "Pune")}));
		
		CompositeCreator cc = new CompositeCreator(js);
		cc.create();
		//cc.print();
		System.out.println(cc.c.toString());
		
//		Composite c = new Composite("enrollment");
//		
//		Leaf l = new Leaf("id", 1);
//		c.add(l);
//		
//		l = new Leaf("name", "Bhavesh");
//		c.add(l);
//		
//		l = new Leaf("phones", new Composite("array").
//				add(new Leaf(0, "9876543210")));
//		c.add(l);
//		
//		l = new Leaf("office_address", new Composite("hash").
//				add(new Leaf("city", "Mumbai")).
//				add(new Leaf("state", "MH")).
//				add(new Leaf("zip", 123456)));
//		c.add(l);
//		
//		l = new Leaf("hotels", new Composite("array").
//				add(new Leaf(0, new Composite("hash").
//						add(new Leaf("id", 2)))).
//				add(new Leaf(1, new Composite("hash").
//						add(new Leaf("id", 2)).
//						add(new Leaf("name", "hotel2")))));
//		c.add(l);
//		c.print();
//		
//		PrintProcessor p = new PrintProcessor();
//		c.useProcessor(p);
//		
//		Visitor v = new Visitor();
//		c.accept(v);
	}
}


