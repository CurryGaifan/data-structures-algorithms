package July_100;

public class Sunday {

	public static void main(String[] args){
//		char[] str = new char[]{'a'};
//		char[] pat = new char[]{'a'};
		String str = "WHICH-FINALLY-HALTS.--AT-THAT-POINT";
		String pat = "AT-THAT";
		
		
		System.out.println(new Sunday().sunday(str.toCharArray(), pat.toCharArray()));
	}
	
	
	
	/**
	 * 
	 * @Title: sunday 
	 * @Description: TODO
	 * @param @param str
	 * @param @param pat
	 * @param @return
	 * @return int >=0:match bit; -1:not match
	 * @throws
	 */
	int sunday(char[] str, char[] pat){
		
		return helper(str, pat, pat.length-1, pat.length-1);
	}
	
	/**
	 * 
	 * @Title: sunday 
	 * @Description: TODO
	 * @param @param str
	 * @param @param pat
	 * @param @return
	 * @return int >=0:match bit; -1:not match
	 * @throws
	 */
	int helper(char[] str, char[] pat, int j, int i){
		
		if(j>(str.length-1))
			return -1;
		
		int equal = isEqual(str, pat, j, i);
		if(equal==1){
			return j-pat.length+1;
		}else{
			int equalbit = findbit(str[j+1], pat);
			if(equalbit>=0){
				return helper(str, pat,j+pat.length-equalbit, pat.length-1);
			}else {
				return helper(str, pat,j+pat.length+1,pat.length-1);
			}
			
		}
	}

	private int findbit(char c, char[] pat) {
		for(int i=pat.length-1; i>=0; i--){
			if(pat[i]==c){
				return i; 
			}
		}
		return -1;
		
	}

	private int isEqual(char[] str, char[] pat, int j, int i){

		for(int m = 0; m <= i; m++ ){
			if(str[j-m] == pat[i-m]){
				
			}else {
				return 0;
			}
		}
		return 1;
	}
}
