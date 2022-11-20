import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] d = new int[n][n];
		
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=0; k<n; k++) {	//k: ���İ��� ���
			for(int i=0; i<n; i++) {	//i: ��� ���
				for(int j=0; j<n; j++) {	//j: ���� ���
					if(d[i][k]==1 && d[k][j]==1) {
						d[i][j]=1;
					}
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(d[i][j]+" ");
			}
			System.out.println();
		}
	}

}
