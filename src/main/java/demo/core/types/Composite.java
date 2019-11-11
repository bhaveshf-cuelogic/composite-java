package demo.core.types;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Type {
	
	public Composite(){
		super();
	}
	
	public Composite(String key, Object value){
		super(key, value);
	}

	@Override
	public String toString() {
		String str = "";
		str += "Composite(subtype_size=["+this.getSubTypes().size()+"], id="+this.hashCode()+", subtypes=[";
		for (int index = 0; index < this.getSubTypes().size(); index ++) {
			str += this.subTypes.get(index).toString();
			str += ", ";
			//str += "\n";
		}
		str += "])";
		return str;
	}

	public Type getSubTypeByName(String keyname) {
		Type t = null;
		for (int index = 0; index < this.getSubTypes().size(); index++) {
			if (((Type)this.getSubTypes().get(index)).getKey().equals(keyname)) {
				System.out.println("Subtype found at "+index+" index");
				t = ((Type)this.getSubTypes().get(index));
			}
		}
		return t;
	}

	public Object findByPattern(String pattern) {
		Object output = "";
		String[] objectPath = pattern.split("\\.");
		Type found = this.getSubTypeByName(objectPath[0]);
		if(found != null) {
			if(found.getValue().getClass().getSimpleName().equals("Composite")) {
				System.out.println("Type's value is of Composite type");
				if(objectPath.length > 1) {
					List<String> tempStrArr = new ArrayList<String>();
					for(int index = 1; index < objectPath.length; index++) {
						tempStrArr.add(objectPath[index]);
					}
					output = ((Composite)found.getValue()).findByPattern(String.join(".", tempStrArr));
				} else {
					output = found.getValue();
				}
			} else {
				System.out.println("Primitive value found");
				output = found.getValue();
			}
		}
		return output;
	}
}
