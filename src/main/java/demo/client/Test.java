package demo.client;

import org.json.JSONException;
import org.json.JSONObject;
import com.jayway.jsonpath.JsonPath;

public class Test {
	public static void main(String[] args) throws JSONException {
		
		//String s = "{\"name\":\"bhavesh\",\"ssn\":\"ABC123\",\"phones\":[123,456],\"address\":{\"city\":\"Pune\"},\"hotels\":[{\"id\":1},{\"id\":2,\"name\":\"hotel2\"}]}";
//		String s = "{'type':'Enrollment','data':[{'provider_id':100,'enrollment':{'name':{'firstName':null,'lastName':'Smith'},'roles':[{'id':{'testing':[{'name':'bhavesh','age':20}]}}],'address':{'name':'nik','phones':[987,7654]},'dob':'29/08/1991'}}]}";
		String s = "{'address':{'city':{'info':{'name':'bhavesh'}}}}";
		//s = "{'type':null}"; // to test NULL value against a key
		JSONObject js = new JSONObject(s);
//		js.deepscan();
//		js.put("TEST", "VALUE");
//		js.deepscan();
//		String out = JsonPath.read(js.toString(), "$.data[0].enrollment.name.firstName");
//		System.out.println(out);
//		System.out.println(js.has("type1"));

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

//		cc.root_composite.printAllKeys();
//		cc.printAllKeys(cc.root_composite.getSubTypes());
//		List<Type> types = (List<Type>) cc.getTypeByName(cc.root_composite.getSubTypes());
//		System.out.println("-------------------"+types.size());
//		
//		String[] objectPath = "address.city.info.name[0].name".split("\\.");
//		Object val = cc.getValueByPath(cc.root_composite.getSubTypes(), objectPath, 0);
//		
		System.out.println(cc.root_composite.findByPattern("address").toString());
		System.out.println(cc.root_composite.findByPattern("address.city").toString());
		System.out.println(cc.root_composite.findByPattern("address.city.info").toString());
		System.out.println(cc.root_composite.findByPattern("address.city.info.name").toString());

//		System.out.println(cc.root_composite.findBy("address.city").toString());

		//System.out.println(cc.root_composite.toString());
//		
//		PrintProcessor p = new PrintProcessor();
//		c.useProcessor(p);
//		
//		Visitor v = new Visitor();
//		c.accept(v);
	}
}
