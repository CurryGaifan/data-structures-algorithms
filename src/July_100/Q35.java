package July_100;

public class Q35 {
	public static void main(String[] args){
		int[][] array = {{1,2,3,4},{-1,-3,-5,3},{1,-5,6,2}};
		new Q35().getMaxArray(array, 3, 4);
	}
	void getMaxArray(int[][] a, int m, int n){
//		int[][] b =new int[m][n];
//		int[][] c =new int[m][n*n];
		int[][] d =new int[m*m][n*n];
		
		for(int i=0;i<m; i++){
			for(int j = 0; j<n; j++){
				if(j==0){
					d[i][j] = a[i][j];
				}else{
					d[i][j] = d[i][j-1] + a[i][j];
				}
			}
		}
		System.out.println("d:");
		for(int[] x: d){
			for(int num :x){
				System.out.print(num + " ");
			}
			System.out.println();
		}
		
		
		for(int i=0;i<m; i++){
			for(int j = 1; j<n; j++){
				for(int k = j; k<n; k++){
					d[i][j*n+k] = d[i][k]- d[i][j-1];
				}
			}
		}
		System.out.println("d:");
		for(int[] x: d){
			for(int num :x){
				System.out.print(num + " ");
			}
			System.out.println();
		}
		

		for(int i=0;i<n*n; i++){
			for(int j = 0; j<m; j++){
				if(j==0){
					d[j][i] = d[j][i];
				}else{
					d[j][i] = d[j-1][i] + d[j][i];
				}
			}
		}
		System.out.println("d:");
		for(int[] x: d){
			for(int num :x){
				System.out.print(num + " ");
			}
			System.out.println();
		}
		
		for(int i=0;i<n*n; i++){
			for(int j = 1; j<m; j++){
				for(int k = j; k<m; k++){
					d[j*m+k][i] = d[k][i]- d[j-1][i];
				}
			}
		}
		System.out.println("d:");
		for(int[] x: d){
			for(int num :x){
				System.out.print(num + " ");
			}
			System.out.println();
		}
		
		
		int max = Integer.MIN_VALUE;
		int x  = Integer.MIN_VALUE;
		int y  = Integer.MIN_VALUE;
		for(int i=0; i<m*m; i++){
			for(int j=0; j<n*n; j++){
				if(d[i][j]>max){
					max = d[i][j];
					x = i;
					y = j;
				}
			}
			
		}
		System.out.println("max: " + max + ", x: " + x + ", y: " + y);
		
		
		
		int  m_start = x/m;
		int m_end = x%m;
		int n_start = y/n;
		int n_end = y%n;
		System.out.println("maxArray : ");
		for(int i =m_start; i<m_end+1; i++){
			for(int j =n_start; j<n_end+1; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	
}
