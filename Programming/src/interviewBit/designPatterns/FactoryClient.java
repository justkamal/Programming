package interviewBit.designPatterns;

import java.util.LinkedList;
import java.util.List;

/*	Use case : If different client requires different set of specific classes of a particular generic
 * 	class then it's better to make a factory class which provides particular set required. For example,
 * 	address validation can be broken down into area, pin code and city validation. For order, we require
 * 	all kinds of address field validations but for say checking whether that particular locality comes
 * 	under service of delivery than we might only need pin code validation.
 * 	Another example is, Amazon order checks all validations but primevideo requires only country 
 * 	validations  
 * 	*/

interface Validator{
	public boolean validate(String address);
}

class CountryValidator implements Validator{

	@Override
	public boolean validate(String country) {
		return false;
	}
	
}

class StateValidator implements Validator{

	@Override
	public boolean validate(String state) {
		return false;
	}
	
}

class RegionValidator implements Validator{

	@Override
	public boolean validate(String region) {
		return false;
	}
	
}

public class FactoryClient {
	
	public static void main(String[] args) {
		List<Validator> validatorList = new LinkedList<Validator>();
		validatorList.add(new CountryValidator());
		validatorList.add(new StateValidator());
		validatorList.add(new RegionValidator());	//add required validators
	}
}


