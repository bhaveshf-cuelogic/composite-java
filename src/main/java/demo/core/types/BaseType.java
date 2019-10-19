package demo.core.types;

import demo.core.processors.TypeProcessor;

public abstract class BaseType {
	Composite parent;
	
	public abstract void print();
	
	public abstract void useProcessor(TypeProcessor tp);
}
