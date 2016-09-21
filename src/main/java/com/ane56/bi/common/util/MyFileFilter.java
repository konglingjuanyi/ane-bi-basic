package com.ane56.bi.common.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class MyFileFilter implements FilenameFilter { //实现FilenameFilter接口  
	   
	    private static List<String> objlist = new ArrayList<String>();
		public static List<String> getObjlist() {
			return objlist;
		}
		public static void setObjlist(List<String> objlist) {
			MyFileFilter.objlist = objlist;
		}
		private String type; // 后缀名
	    public MyFileFilter(String type)
	    {
	        this.type = type;
	    }
	    @Override
		public boolean accept(File dir, String name)
	    {
	        return name.endsWith(type);
	    }
	    /**
	     * 将文本文件中的内容读入到buffer中
	     * @param buffer buffer
	     * @param filePath 文件路径
	     * @throws IOException 异常
	     * @author cn.outofmemory
	     * @date 2013-1-7
	     */
	    public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
	        InputStream is = new FileInputStream(filePath);
	        String line; // 用来保存每行读取的内容
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	        line = reader.readLine(); // 读取第一行
	        while (line != null) { // 如果 line 为空说明读完了
	            buffer.append(line); // 将读到的内容添加到 buffer 中
	            buffer.append("\n"); // 添加换行符
	            line = reader.readLine(); // 读取下一行
	        }
	        reader.close();
	        is.close();
	    }

	    /**
	     * 读取文本文件内容
	     * @param filePath 文件所在路径
	     * @return 文本内容
	     * @throws IOException 异常
	     * @author cn.outofmemory
	     * @date 2013-1-7
	     */
	    public static String readFile(String filePath) throws IOException {
	        StringBuffer sb = new StringBuffer();
	        readToBuffer(sb, filePath);
	        return sb.toString();
	    }
	    public static void filterfile(String path,String dir, String suffix, ArrayList<String> fileList) throws IOException
	    {
	    	HashMap<String, Object> map = new HashMap<String, Object>();
	        File allFile = new File(dir);
	        File [] myList = allFile.listFiles();
	        MyFileFilter filter = new MyFileFilter(suffix);
	        File [] files = allFile.listFiles(filter);
	        if(files!=null ){
	        	for(int i=0;i<files.length;i++){
	        		File file = files[i];
	        		String fileName = file.getName();
	        		String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
	        		if(suffix.equals(prefix)){
	            		String filePath = file.getAbsolutePath();
	            		String context = readFile(filePath);
		            	map.put("filePath", filePath);
		            	map.put("fileName", file.getName());	
		            	map.put("context", context);
		            	objlist.add(JSONUtils.convertObject2Json(map));
	            	}
	        	}
		        for (File a : myList)
		        {
		            if (a.isDirectory())
		            {
		                    filterfile(path,a.toString(), suffix, fileList);
		            }
		        }
	        }
	    }
	    public static void main(String[] args) throws Exception
	    {
	        ArrayList<String> fileList = new ArrayList<String>();
	        MyFileFilter.filterfile("","E:\\ane-bi-basic\\apache-tomcat-7.0.68\\webapps\\ane-bi-basic", ".properties", fileList);
	        for(String s:fileList)
	        {
	            System.out.println(s);
	        }
	        System.out.println("执行完成!");
	    }
} 
 
