import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class SmallestPowOf2GreaterOrEqualN {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			while( (n &(n-1))!=0 ) {
				n++;
			}
			System.out.println(n);
		}
	}
}
