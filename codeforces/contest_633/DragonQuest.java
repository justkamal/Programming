package contest_633;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DragonQuest {
	
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static boolean fightDragon(int health, int abs, int light) {
		if(health > 0) {	
			boolean canDefeat = false;
			int abs_power = (int)Math.floor(health/2) + 10;
			if(abs_power < health && abs > 0) {
					canDefeat |= fightDragon(abs_power, abs - 1, light);
			}
			if(light > 0){
				if(abs == 0) {
					if(health - (10*light) <= 0)
						return true;
					else
						return false;
				} else {
					canDefeat |= fightDragon(health - 10, abs, light - 1);
				}
			}
			return canDefeat;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		int T;

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int health, m, n;
			strz = new StringTokenizer(br.readLine());
			health = Integer.parseInt(strz.nextToken());
			n = Integer.parseInt(strz.nextToken());
			m = Integer.parseInt(strz.nextToken());
			
			boolean canDefeat = fightDragon(health, n, m);
			
			if(canDefeat)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
