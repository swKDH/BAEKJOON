import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11758 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		
		ccw(x1,x2,x3,y1,y2,y3);
		
	}
	private static void ccw(int x1, int x2, int x3, int y1, int y2,int y3) {
		// TODO Auto-generated method stub
		int a = x1*y2 + x2*y3 + x3*y1;
		int b = x2*y1 + x3*y2 + x1*y3;
		if (a-b<0) {
			System.out.println("-1");
		}
		else if (a-b==0) {
			System.out.println("0");
		}
		else {
			System.out.println("1");
		}
	}

}
