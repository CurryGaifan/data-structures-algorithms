package amazon.online.test;

import java.util.Scanner;


public class Q2 {
	public static void main(String[] args) {
		Scanner cin= new Scanner(System.in);
		int count = cin.nextInt();
		int[] start = new int[count];
		int[] end = new int[count];
		int[] high = new int[count];
		int tail =0;
		for(int i =0; i<count; i++){
			String str = cin.next();
			String[] array = str.split(",");
			
			start[i] = Integer.valueOf(array[0]);
			end[i] = Integer.valueOf(array[1]);
			high[i] = Integer.valueOf(array[2]);
			if(end[i] > tail )
				tail = end[i];
		}
		
		int[] hills = new int[tail];
		
		for(int i = 0; i< count; i++){
			for(int j=start[i]; j< end[i];j++){
				if(hills[j] < high[i])
					hills[j] = high[i];
			}
		}
		
		
		int distance = 0 ; 
		int lasthigh = 0 ;
		int i = 0 ;
		for(; i <hills.length;i ++){
//			System.out.println(hills[i]);
			distance = distance + Math.abs(hills[i]- lasthigh)+ 1;
			lasthigh = hills[i];
//			System.out.println(distance);
		}
//		System.out.println(distance);
//		System.out.println( hills[i-1]);
		distance += hills[i-1];
		System.out.println(distance);
	}

}
