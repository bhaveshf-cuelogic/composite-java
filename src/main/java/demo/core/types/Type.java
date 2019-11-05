package demo.core.types;

import java.util.ArrayList;

import demo.core.processors.TypeProcessor;

public class Type {
	Object key; //either string or number
	Object value; //either primitive or another composite object
	ArrayList<Type> subTypes;
	Type parent;

	public Type(){
		this.subTypes = new ArrayList<Type>();
	}

	public Type(Object value){
		this.value = value;
	}

	public Object getKey() {
		return key;
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
		str += "Type(key=" + key.toString() + ", value=" + value.toString() + ", subtype_size=" + this.getSubTypes().size() + ", parent=" + parent.hashCode() + ")";
		return str;
	}

	public Type(Object key, Object v) {
		this.key = key;
		this.value = v;
		this.subTypes = new ArrayList<Type>();
	}

	public Composite add(Type t) {
		this.subTypes.add(t);
		t.parent = this;
		return (Composite)this;
	}
}
