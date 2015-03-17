package July_100;

public class Q56 {
	
	
	
	public static void main(String[] args) {
		String m = "BDCABSDAFSAFSAGADGREGASFASFA";
		String n = "ABCBSADGFDGSAFFDSAGAFSAFDDAB";
		int[][] a= new int[n.length()][m.length()];
		lcs(m , n, a);
		for(int i =0;i <n.length() ;i ++){
			for(int j = 0 ; j <m.length(); j++){
				System.out.print(a[i][j] + " " );
			}
			System.out.println();
		}
		findString(m, n, a);
	}
	
	private static void findString(String m,String n, int[][] a) {
		StringBuilder sb =new StringBuilder();
		int j = m.length()-1;
		int i = n.length()-1;
		while(i>-1 && j>-1){
			if(m.charAt(j) == n.charAt(i)){
				sb.append(m.charAt(j));
				j --;
				i --;
			}else if(a[i][j] == a[i-1][j] && i>0){
				i--;
			}else {
				j--;
			}
		}
		System.out.println(sb.reverse());

		
	}

	static void  lcs(String m , String n, int[][] a){
		boolean find = false;
		for(int i = 0 ; i < m.length() ; i++){
			if(m.charAt(i) == n.charAt(0) || find){
				a[0][i] = 1;
				find = true;
			}
		}
		
		find = false;
		for(int i = 0 ; i < n.length() ; i++){
			if(n.charAt(i) == m.charAt(0) || find){
				a[i][0] = 1;
				find = true;
			}
		}
		
		for(int i = 1; i<n.length(); i++){
			for(int j = 1;j<m.length();j++){
				if(m.charAt(j) == n.charAt(i)){
					a[i][j] = a[i-1][j-1] + 1;
				}else if(a[i-1][j] > a[i][j-1]){
					a[i][j] = a[i-1][j];
				}else {
					a[i][j] = a[i][j-1];
				}
				
			}
		}
		
		
	}

}
