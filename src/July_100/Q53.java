package July_100;

public class Q53 {

	/** 
	 * @Title: main 
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws 
	 */
	public static void main(String[] args) {
		String str = "abcbad";
		new Q53().helper("",str);

	}

	
	public void helper(String prex, String str){
		String tprex = prex;
		if(str.length()==0){
			System.out.println(prex);
			return;
		}
		for(int i=0;i<str.length(); i++){
				if(str.substring(0,i).contains(String.valueOf(str.charAt(i))))
					continue;
			tprex = prex + str.charAt(i);
			if(i== 0 ){
//				System.out.println(tprex + "****" + str.substring(i+1, str.length()));
				helper(tprex, str.substring(i+1, str.length()));
			}else{
//				System.out.println(tprex + "^^^^" + str.substring(0, i)+str.substring(i+1, str.length()));
				helper(tprex, str.substring(0, i)+str.substring(i+1, str.length()));
			}
			
		}
//		System.out.println();
	}
}
