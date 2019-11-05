package demo.core.types;

public class Composite extends Type {
	
	public Composite(){
		super();
	}
	
	public Composite(String key, Object value){
		super(key, value);
	}

	@Override
	public String toString() {
		String str = "";
		str += "Composite(subtype_size=["+this.getSubTypes().size()+"], id="+this.hashCode()+", subtypes=[";
		for (int index = 0; index < this.getSubTypes().size(); index ++) {
			str += this.subTypes.get(index).toString();
			str += ", ";
			//str += "\n";
		}
		str += "])";
		return str;
	}
}
