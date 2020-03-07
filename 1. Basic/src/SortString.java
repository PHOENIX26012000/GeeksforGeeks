import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.HashMap;

class SortString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			char ch[] = br.readLine().trim().toCharArray();
			//Arrays.sort(ch);
			//System.out.println(String.valueOf(ch));
			HashMap<Character, Integer> map = new HashMap<>();
			
			for (int i = 0; i < 26; i++) {
				map.put( (char)('a' + i), null);
			}
			
			for (int i = 0; i < ch.length; i++) {
				Integer val = map.get(ch[i]);
				if(val!=null) {
					map.put(ch[i], val+1);
				}
				else {
					map.put(ch[i], 1);
				}
			}
			
			for (int i = 0; i < 26; i++) {
				if( map.get((char)('a'+i))!=null ){
					for (int j = 0; j < map.get((char)('a'+i)); j++) {
						System.out.print((char)('a'+i));
					}
				}
			}
			System.out.println();
		}
	}
}
