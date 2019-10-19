package demo.core.types;

import java.util.ArrayList;

import demo.core.processors.TypeProcessor;
import demo.core.visitors.Visitor;

public class Composite extends BaseType {
	String type;
	ArrayList<Leaf> children;
	
	public Composite(){
		this.type = "composite"; 
		this.children= new ArrayList<Leaf>();
	}
	
	public Composite(String type){
		this.type = type; 
		this.children= new ArrayList<Leaf>();
	}
	
	public Composite add(Leaf l) {
		l.setParent(parent);
		this.children.add(l);
		return this;
	}
	
	public ArrayList<Leaf> getChildren(){
		return children;
	}
	
	public void accept(Visitor v) {
		v.visit(this);
		this.children.forEach(child -> {
			child.accept(v);
		});
	}
	
	public void print() {
		System.out.println(this.type);
		this.children.forEach(child -> {
			child.print();
		});
	}

	@Override
	public void useProcessor(TypeProcessor tp) {
		tp.process(this);
		this.children.forEach(child -> {
			child.useProcessor(tp);
		});
		// TODO Auto-generated method stub		
	}

	@Override
	public String toString() {
		String str = "Composite [type=" + type + ", children=" + children.size() + "]\n";
		for (Leaf leaf : children) { 		      
			str += leaf.toString()+"\n"; 		
	    }
		return str;
	}
}
