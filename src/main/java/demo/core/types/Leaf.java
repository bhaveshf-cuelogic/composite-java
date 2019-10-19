package demo.core.types;

import demo.core.processors.TypeProcessor;
import demo.core.visitors.Visitor;

public class Leaf extends BaseType {
	String key;
	Object value;
	
	public Leaf(String key, Object obj){
		this.key = key;
		this.value = obj;
	}
	
	public Leaf(int key, Object obj){
		this.key = Integer.toString(key);
		this.value = obj;
	}
	
	public Composite getParent() {
		return parent;
	}

	public void setParent(Composite parent) {
		this.parent = parent;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
		if (this.value.getClass().getSimpleName().equals("Composite")) {
			// this.obj.accept(visitor);
		}
	}
	
	public void print() {
		System.out.println("Key:"+this.key);
		System.out.println("Value:"+this.value);
	}

	@Override
	public void useProcessor(TypeProcessor tp) {
		tp.process(this);
		// TODO Auto-generated method stub		
	}

	@Override
	public String toString() {
		return "Leaf [key=" + key + ", parent_id=" + getParent().hashCode() + ", value=" + value.toString() + "]";
	}
}
