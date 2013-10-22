package fivedot2;


/**CareerCup 5.2
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary 
 * representation. If the number cannot be represented accurately in binary with at most 32 characters, 
 * print "ERROR."
 * 
 * method: 
 * �Ҳ������ʱ��ѧ������֪ʶ��Ȼ�õ��ˡ������������ˡ�����
 * ��ʱ�����������ת������д������������
 * @author gengchen
 *
 */


public class DoubleRepresentation {
	
	public static void main(String[] args){
        double[] num = {0.4, 0.5, 0.75,0.25,0.11, 0.23};
        for (double val : num){
                System.out.println(val + "'s binary representation:  " + Translation(val));
        }
}
	
	
	
	
	public static String Translation(double num){
		if(num < 0 || num >1)
			return "ERROR";
		StringBuffer str = new StringBuffer();
		str.append('0');
		str.append('.');
		while(num != 0){
			if(str.length() > 32)
				return "ERROR";
			num *= 2;
			if(num >= 1){
				num--;
				str.append('1');
			}
			else{
				str.append('0');
			}
		}
		return str.toString();
	}

	
}

