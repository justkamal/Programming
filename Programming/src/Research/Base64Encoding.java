package Research;

import java.util.Base64;

public class Base64Encoding {

	public static void main(String[] args) {
		
		//private
		String username = "7751";
		String password = "B-qa2-0-5f031cdd-0-302d0214496be84732a01f690268d3b8eb72e5b8ccf94e2202150085913117f2e1a8531505ee8ccfc8e98df3cf1748";
		String authString = "Authorization: Basic "
				+ Base64.getEncoder().encodeToString(String.format("%s:%s", username, password).getBytes());
		
		System.out.println(authString);
		
		//public
		String username2 = "7751";
		String password2 = "B-qa2-0-5f031cbe-0-302d021500890ef262296563accd1cb4aab790323d2fd570d30214510bcdacdaa4f03f59477eef13f2af5ad13e3044";
		String authString2 = "Authorization: Basic "
				+ Base64.getEncoder().encodeToString(String.format("%s:%s", username2, password2).getBytes());
		
		System.out.println(authString2);
	}

}
