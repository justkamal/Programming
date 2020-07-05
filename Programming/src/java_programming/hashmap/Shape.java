package java_programming.hashmap;

public abstract class Shape {
	public final int barcode = 1911;
	
	public abstract void display();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + barcode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		if (barcode != other.barcode)
			return false;
		return true;
	}
}