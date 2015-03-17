package amazon.online.test;

import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		Scanner cin= new Scanner(System.in);
		int m = cin.nextInt();
		int n = cin.nextInt();
		int[][] array = new int[n][m];
		for(int i = 0; i < n ; i++){
			for(int j =0 ; j < m;j ++){
				array[i][j] = cin.nextInt();
			}
		}
		
		
		int rightindex = m-1;
		int ldlindex = 0;
		int lddindex = n -1;
		int leftindex = 0;
		int upindex = 0 ;
		int a = 0;
		int b = 0 ; 
		System.out.print(array[a][b]+" ");
		while(true){
			if(b <= rightindex-1){
				b++;
				
				while(b <= rightindex){
					System.out.print(array[a][b++] +" ");
				}
				b--;
				upindex = a+1;
			}
			if(ldlindex<=b-1 && a+1<=lddindex){
				rightindex = b-2;
				a++;
				b--;
				while(ldlindex<=b && a<=lddindex){
					System.out.print(array[a++][b--]+" ");
				}
				a--;
				b++;
			}else {
				break;
			}
			
			if(leftindex<=b-1){
				b--;
				while(leftindex<=b){
					System.out.print(array[a][b--]+" ");
				}
				b++;
				lddindex = a-1;
			}
			
			if(a-1>=upindex){
				a--;
				while(a>=upindex){
					System.out.print(array[a--][b]+" ");
				}
				a++;
				ldlindex = b+1;
				leftindex = b+1;
			}
			
		}
		
		
	}

}
