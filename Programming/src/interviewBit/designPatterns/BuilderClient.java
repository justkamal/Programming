package interviewBit.designPatterns;

/*	Use case : To instantiate a final object
 * */

class House {
	
	private String basement;
	private String structure;
	private String roof;
	private String interior;
	
	public House(HouseBuilder builder) {
		this.basement = builder.basement;
		this.structure = builder.structure;
		this.roof = builder.roof;
		this.interior = builder.interior;
	}
	
	public static class HouseBuilder{
		private String basement = "";
		private String structure = "";
		private String roof = "";
		private String interior = "";
		
		public HouseBuilder() {
			
		}
		
		public HouseBuilder setBasement(String basement) {
			this.basement = basement;
			return this;
		}

		public HouseBuilder setStructure(String structure) {
			this.structure = structure;
			return this;
		}

		public HouseBuilder setRoof(String roof) {
			this.roof = roof;
			return this;
		}

		public HouseBuilder setInterior(String interior) {
			this.interior = interior;
			return this;
		}
		
	}
}

public class BuilderClient {
	public static void main(String[] args) {
		final House house = new House(new House.HouseBuilder().setBasement("base"));	//can only modify while instantiating
	}
}