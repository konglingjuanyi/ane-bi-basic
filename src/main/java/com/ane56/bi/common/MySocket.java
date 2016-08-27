package com.ane56.bi.common;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;

import com.ane56.bi.common.util.DateUtils;
import com.ane56.bi.common.util.MD5Util;

public class MySocket {

	public static void main(String[] args) throws Exception {
		String dateStr = DateUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
		//String encodeDate = URLDecoder.decode("2016-08-23 16:49:51", "UTF-8");
		//String signStr = "defff57e75da3721c47b0aa87481adcfapp_keyane_admindata{"pageNo":1,"pageSize":100}"+"defff57e75da3721c47b0aa87481adcf";
		String data="{"+"\"pageNo\":"+"1,\"pageSize\":100}";
		System.out.println(data);
		//String md5str = MD5Util.md5Hex("ab179020b82d2fdcd4cea176796f7156app_keyapitestdata%7B%22carnum%22:%22%E4%BA%ACA09999%22%7Dmethodips2.api.currentStatustimestamp2012-09-19%2019:12:05ab179020b82d2fdcd4cea176796f7156");
		String md5Str = "defff57e75da3721c47b0aa87481adcfapp_keyane_admindata{"+"\"pageNo\":"+"1,\"pageSize\":100}methodclassline.postline.getPostLineInfotimestamp"+dateStr+"defff57e75da3721c47b0aa87481adcf";
        String sign = MD5Util.md5Hex(md5Str).toUpperCase();
		//String aa = "ab179020b82d2fdcd4cea176796f7156app_keyapitestdata{"+"\"carnum\""+":"+"\"京A09999\"}methodips2.api.currentStatustimestamp2012-09-19 19:12:05ab179020b82d2fdcd4cea176796f7156";
		System.out.println(md5Str);
		System.out.println(sign);
		new MySocket().testURLConnection(dateStr,sign,data);
		/*System.out.println(dateStr);
		System.out.println(encodeDate);
		new MySocket().testURLConnection(dateStr,signStr,data);*/
		//new MySocket().testSocket();
	}
	
	public void testSocket() throws Exception
	{
		Socket socket = new Socket("blog.sina.com.cn", 80);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		pw.println("GET /s/blog_4940e1fc01013cyh.html HTTP/1.1");
		pw.println("Host:localhost");
		pw.println("Content-type: text/html");
		pw.println();
		pw.flush();
		long startTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String str = "";
		while((str = br.readLine()) != null)
		{
			System.out.println(str);
		}
		System.out.println((System.currentTimeMillis() - startTime)/1000);
		br.close();
		pw.close();
		socket.close();
		System.out.println(socket.isClosed() +"---------------------" + "*******************");
		System.out.println((System.currentTimeMillis() - startTime)/1000);
	}
	
	public void testURLConnection(String dateStr,String signStr,String data) throws Exception
	{
		String urlStr = "test.api.g7s.chinawayltd.com/interface/index.php?app_key=ane_admin&method=classline.postline.getPostLineInfo";
		URL url = new URL(urlStr+"&timestamp="+dateStr+"&sign="+signStr+"&data="+data);
		URLConnection con = url.openConnection();
		con.setDoOutput(true);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(con.getOutputStream()));
		pw.println("post / HTTP/1.1");
		pw.println("http://gateway.ppsms.com:3580/");
		pw.println("Content-type: text/html; charset=utf-8;");
		pw.println();
		pw.flush();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String str = "";
		while((str = br.readLine()) != null)
		{
			System.out.println(str);
		}
		br.close();
		pw.close();
	}
	
	
	public void testConnection() throws Exception
	{
		// 首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。
				// URL url = new URL("http://115.29.148.33/bestcool/weixin/send.html?secret=codecode");
		String date = DateUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
		String encodeDate = URLEncoder.encode(date, "UTF-8");
		URL url = new URL("httt://test.api.g7s.chinawayltd.com/interface/index.php?app_key=ane_admin&method=classline.postline.getPostLineInfo&timestamp=2014-11-10+10%3A12%3A00&data=[{%22carnum%22:%22\u4eac99999%22,%22price%22:%221000%22,%22starttime%22:%222014-11-6%22,%22endtime%22:%222015-11-6%22,%22carowner_name%22:%22\u4f9b\u5e94\u55461%22,%22contract_no%22:%22A-20141028-006%22,%22sync_line%22:%22\u5317\u4eac-\u4e0a\u6d77%22,%22carmodel%22:%227.6%22}]&sign=6F3F9CE6519B61C27F9940CEEA17D64B");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// 以POST方式传值
		connection.setRequestMethod("POST");
		connection.setConnectTimeout(5 * 1000);// 设置连接超时时间为5秒 JDK1.5+
		connection.setReadTimeout(20 * 1000);// 设置读取超时时间为20秒 JDK1.5+

		// 打算使用 URL 连接进行输出，则将 DoOutput 标志设置为 true
		connection.setDoOutput(true);

		// 这里只设置内容类型与内容长度的头字段根据传送内容决定
		// 内容类型Content-Type:
		// application/x-www-form-urlencoded、text/xml;charset=GBK
		// 内容长度Content-Length: 38
		connection.setRequestProperty("Content-Type", "text/xml;charset=GBK");

		// String json =
		// "{\"touser\":\"or260jll6N3lFmuKLpIfEvfS8xqg\",\"msgtype\":\"text\",\"text\":{\"content\":\"Hello World\"}}";

		StringBuffer bufferString = new StringBuffer();
		InputStream l_urlStream = connection.getInputStream();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(l_urlStream));

		String sCurrentLine = "";
		while ((sCurrentLine = buffer.readLine()) != null) {
			bufferString.append(sCurrentLine);
		}
		System.out.println(bufferString.toString());
		l_urlStream.close();
	}
}
