package util;

public class Tools {
	/**
	 * 将id长度用0补齐
     * @param courseId
     * @param length 长度
     * @return
     */
    public static String formatIdString(int id, int length) {
        String f = "%0" + length + "d";
        return String.format(f, id);
    }

    public static String formatIdString(String id, int length) {
    	return formatIdString(Integer.parseInt(id), length);
    }

	public static String formatIdString(long id, int length) {
		return formatIdString((int)id, length);
	}
	
    public static String getEncoding(String str) {  
        String[] encodes = {"GB2312","UTF-8","GBK"}; 
        for (String encode : encodes) {
        	try {  
        		if (str.equals(new String(str.getBytes(encode), encode))) {  
        			String s = encode;  
        			return s;  
        		}  
        	} catch (Exception exception) {  
        		exception.printStackTrace();
        	}  
		}
        return "";  
    } 
}
