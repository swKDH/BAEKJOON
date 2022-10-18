
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1427 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String s = buffer.readLine();
		
		char[] arr = new char[s.length()];
		for (int i=0; i<s.length(); i++) {
			arr[i] =s.charAt(i); // Áß¿ä 
		}
		Arrays.sort(arr);
		
		for (int j=arr.length-1; j>=0; j--) {
			System.out.print(arr[j]);
		}
	}
}

