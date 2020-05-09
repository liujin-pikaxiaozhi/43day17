package com.liujin.pregnant.util;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.InflaterInputStream;

public class StreamUtil {

	/*
	* 方法1：批量关闭流，参数能传入无限个。(10分)
	* 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限。
	*/
	public static void closeAll(Closeable ...io){
		//TODO 实现代码
		for (Closeable closeable : io) {
			try {
				if (null!=closeable) {
					closeable.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	/*
	* 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
	*/
	public static String readTextFile(InputStream src){
		//TODO 实现代码
		BufferedInputStream stream = new BufferedInputStream(src);
		String read="";
		String r1="";
		while ((read=stream.toString())!=null) {
			r1+=read;
		}
		StreamUtil.closeAll(src,stream);
		return r1;
	}

	/*
	* 方法3：传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	*/
	@SuppressWarnings("resource")
	public static String readTextFile(File txtFile) throws FileNotFoundException{
		//TODO 实现代码
		InputStream inputStream = new FileInputStream(txtFile);
		String readTextFile = StreamUtil.readTextFile(inputStream);
		return readTextFile;
	}

	
}
