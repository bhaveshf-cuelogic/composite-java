package demo.nikhil.bhavesh.core.types;

import java.util.ArrayList;

public class Composite {
	String key; // parent name
	String kind_of; // datatype of composite
	ArrayList<Object> subTypes; // child list

	public Composite() {
		this.key = "EMPTY_KEY";
		this.kind_of = "EMPTY_KIND_OF";
		this.subTypes = new ArrayList<Object>();
	}

	public Composite(String key) {
		this.key = key;
		this.kind_of = "EMPTY_KIND_OF";
		this.subTypes = new ArrayList<Object>();
	}

	public Composite(String key, String kind_of) {
		this.key = key;
		this.kind_of = kind_of;
		this.subTypes = new ArrayList<Object>();
	}

	public String getKind_of() {
		return kind_of;
	}

	public void setKind_of(String kind_of) {
		this.kind_of = kind_of;
	}

	public Composite add(Object t) {
		System.out.println(
				"Adding '" + t.getClass().getSimpleName() + "' type of object to " + this.getKey() + " subtypes");
		this.subTypes.add(t);
		return this;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ArrayList<Object> getSubTypes() {
		return subTypes;
	}

	@Override
	public String toString() {
		String final_str = "";
		ArrayList<String> subytypes_str = new ArrayList<String>();
		final_str += "Composite(key=" + this.key + ", kind_of=" + this.getKind_of() + ", subtype_size=["
				+ this.getSubTypes().size() + "], subtypes=[";
		for (int index = 0; index < this.getSubTypes().size(); index++) {
			subytypes_str.add(this.subTypes.get(index).toString());
		}
		final_str += String.join(",", subytypes_str) + "])";
		return final_str;
	}
}
