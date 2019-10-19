package demo.core.visitors;

import demo.core.types.BaseType;

public class Visitor {
	public void visit(BaseType o) {
		o.print();
	}
}
