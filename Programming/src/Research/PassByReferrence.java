package Research;

public class PassByReferrence {
		
	private String property;
	
	public PassByReferrence() {
		this.property = "S";
	}
	
	public void change(PassByReferrence obj) {
		obj.property = "B";
	}
	
	public static void main(String[] args) {
		PassByReferrence obj = new PassByReferrence();
		obj.change(obj);
		System.out.println(obj.property);
	}

}
