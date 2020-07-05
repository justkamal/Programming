package interviewBit.designPatterns;

/* 	Use case : 	DAO object should be created only once to reduce the cost to again and again establishing 
 * 				the connection to the database
 * 
 * 	Design Pattern : Singleton
 * 	Since there could be multiple calls from client classes requesting for DAO object we'll make a single 
 * 	instance for all 
*/  

class DAO {
	
	private static DAO obj = null;		//Due to static, obj can now be shared for all instances of DAO 
	
	private DAO() {
		System.out.println("Object Instantiated");
	}
	
	public static DAO getInstance() {
		if(obj == null)
			obj = new DAO();
		return obj;
	}	
}

public class SingletonClient {
	//Demo
	public static void main(String[] args) {
		//DAO obj = new DAO();	//will throw error due to private constructor
		DAO obj1 = DAO.getInstance();
		DAO obj2 = DAO.getInstance();
		if(obj1.hashCode() == obj2.hashCode())
			System.out.println("Same");
	}
}