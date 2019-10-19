package demo.nikhil;

import java.util.ArrayList;
import java.util.List;

public class Type {

	private String name;
	private String parentName;
	private ArrayList<Type> subTypes = new ArrayList<Type>();
	private ArrayList<String> subName = new ArrayList<String>();

	public Type(String name) {
		super();
		this.name = name;
	}

	public Type(String name, String parentName) {
		super();
		this.name = name;
		this.parentName = parentName;
	}

	@Override
	public String toString() {
		return "Type [name=" + name + "]";
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Type> getAllTypes() {
		return subTypes;

	}

	public Type addsubName(String name) {
		subName.add(name);
		return this;
	}

	public List getSubNames() {
		return subName;
	}

}