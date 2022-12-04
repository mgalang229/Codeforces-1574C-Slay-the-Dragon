import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class AuthorSol {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
//		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			long[] heroPower = fs.readLongArray(n);
			int m = fs.nextInt();
			long sum = 0;
			for (int i = 0; i < n; i++) {
				sum += heroPower[i];
			}
			shuffleSort(heroPower);
			for (int qry = 1; qry <= m; qry++) {
				long dragDef = fs.nextLong(), dragAttack = fs.nextLong();
				long heroTotal = sum;
				int low = 0, high = n;
				while (low < high) {
					int mid = low + (high - low) / 2;
					if (dragDef <= heroPower[mid]) {
						high = mid;
					} else {
						low = mid + 1;
					}
				}
				int index = low;
				if (index < n && heroPower[index] < dragDef) {
					index++;
				}
				long ans = Long.MAX_VALUE;
				if (index > 0) {
					ans = Math.min(ans, (dragDef - heroPower[index-1]) + Math.max(0, dragAttack - heroTotal + heroPower[index-1]));
				}
				if (index < n) {
					ans = Math.min(ans, Math.max(0, dragAttack - heroTotal + heroPower[index]));
				}
				System.out.println(ans);
			}
		}
		out.close();
	}

	static final Random rnd = new Random();
	
	static void shuffleSort(long[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			long temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
