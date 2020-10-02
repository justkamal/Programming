package contest_652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccurateLee {
	private static BufferedReader br;

	public static int compute(StringBuffer bin) {
		int i = 0;

		while (i < bin.length()) {
			if (i + 1 < bin.length() && bin.charAt(i) == '1' && bin.charAt(i + 1) == '0') {
				
				StringBuffer str1 = new StringBuffer(bin);
				StringBuffer str2 = new StringBuffer(bin);
				
				str1.setCharAt(i+1, '1');
				str1.deleteCharAt(i);
				
				str2.setCharAt(i+1, '0');
				str2.deleteCharAt(i);
				
				int len1 = compute(str1);
				int len2 = compute(str2);
				
				if(len1 < len2)
					bin = new StringBuffer(str1);
				else
					bin = new StringBuffer(str2);
			} else {
				++i;
			}
		}
		return bin.length();
	}

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());

		while (test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringBuffer bin = new StringBuffer(br.readLine());

			compute(bin);

			System.out.println(bin);
		}

	}
}
