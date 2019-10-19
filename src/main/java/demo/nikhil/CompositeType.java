package demo.nikhil;

import java.util.ArrayList;
import java.util.List;

public class CompositeType extends Type {

	private String name;
	private String parentName;
	private ArrayList<Type> subTypes = new ArrayList<Type>();
	private ArrayList<String> subName = new ArrayList<String>();

	public CompositeType add(Type minion) {
		subTypes.add(minion);
		return this;
	}

	public CompositeType addsubName(String name) {
		subName.add(name);
		return this;
	}

	public List getSubNames() {
		return subName;
	}

	public ArrayList<Type> getAllTypes() {
		return subTypes;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public CompositeType(String name) {
		super(name);
		this.name = name;
	}

	public CompositeType(String name, String parentName) {
		super(name, parentName);
		this.name = name;
		this.parentName = parentName;
	}

	@Override
	public String toString() {
		return "CompositeType [name=" + name + ", subTypes=" + subTypes + "]";
	}

}
