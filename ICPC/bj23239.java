import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj23239 {
	static long carrot;
	static long w, h, l, result =0;
	public static long can_eat(long r) {
		carrot = 0;
		long j = r-1;
		for(long i =1;i<r;i++) {
			while(i * i + j * j > r * r) j--;
			carrot += j;
		}
		return carrot;
	}
	
	public static long remove() {
		carrot = 0;
		long j = l-h-1;
		for(long i = h+1;i<l-w;i++) {
			while(((i - h) * (i - h) + j * j > (l - h) * (l - h)) || ((j - w) * (j - w) + i * i > (l - w) * (l - w))) j--;
	        carrot += (j - w);
		}
		return carrot;
	}
	public static void main(String[] args) throws IOException {
		
		bj23239 n = new bj23239();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		w = Long.parseLong(st.nextToken());
		h = Long.parseLong(st.nextToken());
		l = Long.parseLong(st.nextToken());
		
		result +=((2*l) + (3* n.can_eat(l)));
		if(l > h) result += n.can_eat(l-h) + l - h;
		if(l > w) result += n.can_eat(l-w) + l - w;
		if(l - h > w && l - w > h) result -= remove();
		System.out.println(result);
	}

}
