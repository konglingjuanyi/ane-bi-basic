package com.ane56.bi.common;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import com.ane56.bi.common.util.DateUtils;
import com.ane56.bi.common.util.MD5Util;

public class AppHttp {

	public static final String ADD_URL = "http://test.api.g7s.chinawayltd.com/interface/index.php";

    public static void appadd() throws IOException {

     try{
    	 String dateStr = DateUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
    	 String md5Str = "defff57e75da3721c47b0aa87481adcfapp_keyane_admindata{"+"\"pageNo\":"+"1,\"pageSize\":100}methodclassline.postline.getPostLineInfotimestamp"+dateStr+"defff57e75da3721c47b0aa87481adcf";
         String sign = MD5Util.md5Hex(md5Str).toUpperCase();
            //创建连接
            URL url = new URL(ADD_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            
            //connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");       
            
            connection.connect();

            //POST请求
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            JSONObject obj = new JSONObject();
            obj.put("sign",sign);

           /* obj.put("orderId", "4444444444444"); // 订单号
            
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        System.out.println(sf.format(new Date()));
			obj.put("compTime",sf.format(new Date())); // 投诉时间

			obj.put("comperAddress", "我是一个兵"); // 投诉人地址
*/			
            //System.out.println(obj.toString());
          
            //out.writeBytes(obj.toString());//这个中文会乱码
            out.write(obj.toString().getBytes("UTF-8"));//这样可以处理中文乱码问题
            out.flush();
            out.close();
            
            //读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            System.out.println(sb);
            reader.close();
            // 断开连接
            connection.disconnect();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }

    public static void main(String[] args) {
 
    }
}
