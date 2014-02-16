
public class CompareVersion {

	
	public boolean compareVersion(String str1, String str2){
		
		boolean retvalue = false;
		
		String subString1 = str1.substring(str1.length()-1);
		String preSubString1 = str1.substring(0,str1.length()-1);
		System.out.println("The subString1 is " + subString1);
		
		String subString2 = str2.substring(str2.length()-1);
		String preSubString2 = str2.substring(0,str2.length()-1);
		System.out.println("The subString2 is " + subString1);
		
		if(preSubString1.equalsIgnoreCase(preSubString2) && 
				Integer.parseInt(subString2) > Integer.parseInt(subString1)){
			System.out.println("The is new version available!>>>" + str2);
			retvalue=true;
			
		}else{
			System.out.println("No new version availabe, old verion = " + str1);
		}
		
		return false;
		
	}
	
	public int compareStrng(String str1, String str2){
		
//		String[] vals1 = str1.split("(?!^)");
//		String[] vals2 = str2.split("(?!^)");
//		str1= new StringBuilder(str1).reverse().toString();
//		str2= new StringBuilder(str2).reverse().toString();

		
		String[] vals1 = str1.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
		String[] vals2 = str2.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
		
		int i=0;
		int diff;
		while(i<vals1.length && i<vals2.length && vals1[i].equals(vals2[i])) {
		  i++;
		}
		
		if (i<vals1.length && i<vals2.length) {
			
			if(vals1[i].matches("\\d.*")&& vals2[i].matches("\\d.*")){
				 diff = Integer.valueOf(vals1[i]).compareTo(Integer.valueOf(vals2[i]));
			}else {
			     diff = Integer.valueOf(vals1[i].charAt(0)).compareTo(Integer.valueOf(vals2[i].charAt(0)));
			}
			
		    
		    System.out.println("return diff Int =" + diff);
		    
//		    int diff2=Integer.valueOf('A').compareTo(Integer.valueOf('B'));
//		    
//		    System.out.println("return diff2 Int =" + diff2);
		    
		    return Integer.signum(diff);
		}

		return Integer.signum(vals1.length - vals2.length);
		
		
		
	}
	

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareVersion cp = new CompareVersion();
		
		//boolean newVersion= cp.compareVersion("CCCCC/5", "CCCCc/4");
		int returnValue = cp.compareStrng("R2100C", "R20B");
		System.out.println("return Int =" + returnValue);
	}

}
