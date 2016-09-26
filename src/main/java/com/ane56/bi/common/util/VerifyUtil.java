package com.ane56.bi.common.util;

import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.Map;

public class VerifyUtil {

    public static boolean isNullObject(String[][] content, OutputStream os) {
        // TODO Auto-generated method stub
        if(content != null && content.length > 0 && os != null)
        {
            return false;
        }
        return true;
    }

    public static boolean isNull2DArray(String[][] content) {
        // TODO Auto-generated method stub
        if(content != null && content.length > 0)
        {
            return false;
        }
        return true;
    }

    public static boolean isNullObject(NumberFormat nf) {
        // TODO Auto-generated method stub
        if(nf != null)
        {
            return false;
        }
        return true;
    }

    public static boolean isNullObject(String sheetName) {
        if(sheetName != null && !"".equals(sheetName.trim()))
        {
            return false;
        }
        return true;
    }

    public static boolean isNullObject(Map<String, String[][]> content,
            OutputStream os) {
        // TODO Auto-generated method stub
        if(content != null && content.size() > 0 && os != null)
        {
            return false;
        }
        return true;
    }

    public static boolean isNull1DArray(String[] mergeInfo) {
        // TODO Auto-generated method stub
        if(mergeInfo != null && mergeInfo.length > 0)
        {
            return false;
        }
        return true;
    }

   /* public static boolean isNullObject(WritableSheet sheet) {
        // TODO Auto-generated method stub
        if(sheet != null)
        {
            return false;
        }
        return true;
    }*/

}