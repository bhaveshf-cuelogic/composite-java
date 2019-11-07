package demo.client;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import demo.core.types.Composite;
import demo.core.types.Type;

public class CompositeCreator {
	Object input_data;
	Composite root_composite;
	
	CompositeCreator(Object input_data){
		this.input_data = input_data;
		this.root_composite = new Composite();
	}
	
	public Composite create() throws JSONException {
		System.out.println("\nInput data : "+this.input_data);
		if (this.input_data instanceof JSONArray) {
			System.out.println("JSONArray Received");
			JSONArray js_arr_obj = (JSONArray) this.input_data;
			for (int index = 0 ; index < js_arr_obj.length(); index ++) {
				System.out.println("Key : "+index+"\nValue : "+js_arr_obj.get(index)+"\nValue Type : "+js_arr_obj.get(index).getClass().getSimpleName());
				switch(js_arr_obj.get(index).getClass().getSimpleName()) {
					case "JSONArray":
					case "JSONObject":{
						System.out.println("1) Adding new composite leaf to "+index);
						this.root_composite.add(new Type(index, new CompositeCreator(js_arr_obj.get(index)).create()));
					}
					break;
					default:
						System.out.println("2) Adding new primitive leaf to "+index+"\n");
						this.root_composite.add(new Type(index, js_arr_obj.get(index)));
						break;
				};
				
			}
		} else if(this.input_data instanceof JSONObject) {
			System.out.println("JSONObject Received");
			JSONObject js_obj = (JSONObject) this.input_data;
			for (int index = 0 ; index < js_obj.length(); index ++) {
				System.out.println("Key : "+js_obj.names().getString(index)+"\nValue : "+js_obj.get(js_obj.names().getString(index))+"\nValue Type : "+js_obj.get(js_obj.names().getString(index)).getClass().getSimpleName());
				switch(js_obj.get(js_obj.names().getString(index)).getClass().getSimpleName()) {
					case "JSONArray":
					case "JSONObject":{
						System.out.println("3) Adding new composite leaf to "+js_obj.names().getString(index));
						this.root_composite.add(new Type(js_obj.names().getString(index), new CompositeCreator(js_obj.get(js_obj.names().getString(index))).create()));
					}
					break;
					default:
						System.out.println("4) Adding new primitive leaf to "+js_obj.names().getString(index)+"\n");
						this.root_composite.add(new Type(js_obj.names().getString(index), js_obj.get(js_obj.names().getString(index))));
						break;
				};
				
			}
		} else {
			System.out.println("UNHANDLED TYPE RECEIVED"+this.input_data.getClass().getName());
		}
		return this.root_composite;
	}

	public void printAllKeys(ArrayList<Type> subtypes_arr) {
		for(int index = 0; index < subtypes_arr.size(); index++) {
			System.out.println("Key : " + subtypes_arr.get(index).getKey());
			switch(subtypes_arr.get(index).getValue().getClass().getSimpleName()) {
			case "Composite": {
				Composite c = (Composite)subtypes_arr.get(index).getValue();
				printAllKeys(c.getSubTypes());
			}
			break;
			default: {
				//System.out.println("Primitive type detected : "+subtypes_arr.get(index).getValue().getClass().getSimpleName());
			}
			break;
			}
		}
	}
}