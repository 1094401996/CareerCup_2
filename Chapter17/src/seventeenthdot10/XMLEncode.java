package seventeenthdot10;

import org.w3c.dom.Element;

public class XMLEncode {

	
	
	public static void encode(Element root,StringBuffer sb){
		encode(root.getNameCode(),sb);
		for(Attribute a :root.attributes){
			encode(a,sb);
			
		}
		encode("0",sb);
		
		if(root.value != null && root.value != "")
			encode(root.value,sb);
		else{
			for(Element e : root.children){
				enode(e,sb);
			}
		}
		encode("0",sb);
	}
	
	
	public static void encode(String v, StringBuffer sb){
		sb.append(v);
		sb.append(" ");
	}
	
	public static void encode(Attribute attr ,StringBuffer sb){
		encode(attr.getTagCode(),sb);
		encode(attr.value,sb);
	}
	
	public static String encodeToString(Element root){
		StringBuffer sb = new StringBuffer();
		encode(root,sb);
		return sb.toString();
	}
}
