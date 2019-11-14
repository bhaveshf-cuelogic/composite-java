package demo.nikhil.bhavesh.client;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import demo.nikhil.bhavesh.core.types.Composite;
import demo.nikhil.bhavesh.core.types.Type;

public class CompositeCreator {
	Object input_data;
	Composite root_composite;

	CompositeCreator(Object input_data) {
		this.input_data = input_data;
		this.root_composite = new Composite("root");
	}
	
	CompositeCreator(Object input_data, String key) {
		this.input_data = input_data;
		this.root_composite = new Composite(key);
	}
	
	CompositeCreator(Object input_data, String key, String kind_of) {
		this.input_data = input_data;
		this.root_composite = new Composite(key, kind_of);
	}

	public Composite create() throws JSONException {
		System.out.println("\nInput data : " + this.input_data);
		if (this.input_data instanceof JSONObject) {
			System.out.println("JSONObject Received");
			JSONObject js_obj = (JSONObject) this.input_data;
			for (int index = 0; index < js_obj.length(); index++) {
				String valueType = js_obj.get(js_obj.names().getString(index)).getClass().getSimpleName(); 
				switch (valueType) {
				case "JSONObject": 
				case "JSONArray": {
					System.out.println("1) Adding new "+valueType+" to " + js_obj.names().getString(index));
					this.root_composite.add(new CompositeCreator(js_obj.get(js_obj.names().getString(index)), js_obj.names().getString(index), valueType).create());
				}
					break;
				default:
					System.out.println("2) Adding new primitive to " + js_obj.names().getString(index) + "\n");
					this.root_composite.add(new Type(js_obj.names().getString(index), js_obj.get(js_obj.names().getString(index))));
					break;
				}
			}
		}
		else if (this.input_data instanceof JSONArray) {
			System.out.println("JSONArray Received");
			JSONArray js_arr_obj = (JSONArray) this.input_data;
			for (int index = 0; index < js_arr_obj.length(); index++) {
				String valueType = js_arr_obj.get(index).getClass().getSimpleName();
				switch (valueType) {
				case "JSONObject": 
				case "JSONArray": {
					System.out.println("3) Adding new "+valueType+" to " + index);
					this.root_composite.add(new CompositeCreator(js_arr_obj.get(index), Integer.toString(index), valueType).create());
				}
					break;
				default:
					System.out.println("4) Adding new primitive to " + index + "\n");
					this.root_composite.add(new Type(Integer.toString(index), js_arr_obj.get(index)));
					break;
				}
			}
		}
		else {
			System.out.println("UNHANDLED TYPE RECEIVED" + this.input_data.getClass().getName());
		}
		return this.root_composite;
	}
}