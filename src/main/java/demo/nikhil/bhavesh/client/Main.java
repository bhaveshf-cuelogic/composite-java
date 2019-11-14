package demo.nikhil.bhavesh.client;

import org.json.JSONException;
import org.json.JSONObject;

import demo.nikhil.bhavesh.core.types.*;

public class Main {

	public static void main(String[] args) throws JSONException {
		String s = "{\"name\":\"bhavesh\",\"phones\":[123,456],\"address\":{\"city\":\"Pune\"},\"hotels\":[{\"id\":1},{\"id\":2,\"name\":\"hotel2\"}]}";
//		s = "{'type':'Enrollment','data':[{'provider_id':100,'enrollment':{'name':{'firstName':null,'lastName':'Smith'},'roles':[{'id':{'testing':[{'name':'bhavesh','age':20}]}}],'address':{'name':'nik','phones':[987,7654]},'dob':'29/08/1991'}}]}";
//		s = "{'address':{'city':{'info':{'name':'bhavesh'}}}}";
//		s = "{'address1':'bhavesh', 'address':{'city':{'info':{'name':'bhavesh'}}}}";
//		s = "{'phones': ['999','888']}";
//		s = "{'phones': [{'name':'bhavesh'},{'name':'nikhil'}]}";
//		s = "{'a':true}";
		//s = "{'type':null}"; // to test NULL value against a key
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
		
		CompositeCreator cc = new CompositeCreator(js, "enrollment");
		cc.create();
		
//		Composite c = new Composite("enrollment");
//		c.add(new Type("name", "bhavesh"));
//		c.add(new Composite("phones", "object").
//				add(new Type("phones[0]", "9876543210")).
//				add(new Type("phones[1]", "9999999999"))
//			);
		
		System.out.println(cc.root_composite.toString());

//		cc.root_composite.printAllKeys();
//		cc.printAllKeys(cc.root_composite.getSubTypes());
//		List<Type> types = (List<Type>) cc.getTypeByName(cc.root_composite.getSubTypes());
//		System.out.println("-------------------"+types.size());
//
//		System.out.println(cc.root_composite.findByPattern("address").toString());
//		System.out.println(cc.root_composite.findByPattern("address.city").toString());
//		System.out.println(cc.root_composite.findByPattern("address.city.info").toString());
//		System.out.println(cc.root_composite.findByPattern("address.city.info.name").toString());
//		System.out.println(cc.root_composite.findByPattern("phones.0").toString());
//		System.out.println(cc.root_composite.findByPattern("phones.1.name").toString());

//		PrintProcessor p = new PrintProcessor();
//		c.useProcessor(p);
//		
//		Visitor v = new Visitor();
//		c.accept(v);
	}
}
