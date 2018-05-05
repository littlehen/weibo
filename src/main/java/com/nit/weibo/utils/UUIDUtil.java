package com.nit.weibo.utils;

import java.util.UUID;

public class UUIDUtil {
	//下面是我的取uuidname防止文件同名问题  fileName是文件名，包含.后缀名
    private static String getExtName(String s, char split) {    
    	int i = s.lastIndexOf(split);    
    	int leg = s.length();    
    	return i > 0 ? (i + 1) == leg ? " " : s.substring(i+1, s.length()) : " ";    
	}    
      
    public static String getUUIDFileName(String fileName){    
    	UUID uuid = UUID.randomUUID();    
    	StringBuilder sb = new StringBuilder(100);    
    	sb.append(uuid.toString()).append(".").append(getExtName(fileName, '.'));    
    	return sb.toString();    
    }
}
