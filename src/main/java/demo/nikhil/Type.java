package demo.nikhil;

import java.util.ArrayList;
import java.util.List;

public class Type {
	Object key; // either string(for map) or number(for array)
	Object value; // either primitive or another composite object
	ArrayList<Type> subTypes;
	Type parent;

	public Type() {
		this.subTypes = new ArrayList<Type>();
	}

	public Type(Object value) {
		this.value = value;
	}

	public Type(Object key, Object v) {
		this.key = key;
		this.value = v;
		this.subTypes = new ArrayList<Type>();
	}

	public Object getKey() {
		return key.toString();
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public ArrayList<Type> getSubTypes() {
		return subTypes;
	}

	public void setChildren(ArrayList<Type> children) {
		this.subTypes = children;
	}

	public Type getParent() {
		return parent;
	}

	public void setParent(Type parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		String str = "";
		str += "Type(key=" + key.toString() + ", value=" + value.toString() + ", subtype_size="
				+ this.getSubTypes().size() + ", parent=" + parent.hashCode() + ")";
		return str;
	}

	public Composite add(Type t) {
		this.subTypes.add(t);
		t.parent = this;
		return (Composite) this;
	}

	public void printAllKeys() {
		for (int index = 0; index < this.getSubTypes().size(); index++) {
			System.out.println("Key : " + this.getSubTypes().get(index).getKey());
			switch (this.subTypes.get(index).getValue().getClass().getSimpleName()) {
			case "Composite": {
				Composite c = (Composite) this.subTypes.get(index).getValue();
				c.printAllKeys();
			}
				break;
			default: {
// System.out.println("Primitive type detected :
// "+this.subTypes.get(index).getValue().getClass().getSimpleName());
			}
				break;
			}
		}
	}
}