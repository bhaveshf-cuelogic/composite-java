package demo.nikhil.bhavesh.core.types;

public class Type {
	String key; //either string(for map) or number(for array)
	Object value; //only primitive type

	public Type(String key, Object v) {
		this.key = key;
		this.value = v;
	}

	public Type() {
		// TODO Auto-generated constructor stub
	}

	public Object getKey() {
		return key.toString();
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		String str = "";
		str += "Type(key=" + key.toString() + ", value=" + value.toString() + ")";
		return str;
	}
}
