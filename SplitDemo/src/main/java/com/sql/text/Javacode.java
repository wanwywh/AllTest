package com.sql.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

import com.json.format.WriteFile;

public class Javacode {
	// 按行读取 以行为单位读取文件内容，一次读一整行：类似于map程序
	public static void wordcount(String fileName, String writeFileString,
			String tablename) throws IOException {
		File file = new File(fileName);
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		String tempString = null;
		int line = 1;
		// 一次读入一行，直到读入null为文件结束

		while ((tempString = reader.readLine()) != null) {
			// 显示行号
			// StringTokenizer stringTokenizer = new
			// StringTokenizer(tempString);
			if (tempString.length() <= 0) {
				System.out.println(tempString);
			} else {
				try {
					double max = 6.9;
			        double min = 2.1;
					double rand = min + ((max - min) * new Random().nextDouble());
					DecimalFormat df = new DecimalFormat("#.00");  
//					System.out.println(df.format(rand));
//					WriteFile.writeFileByLines(writeFileString,
//							"if(url.contains(\"" + tempString + "\")){return " + df.format(rand) + ";}");
				
					WriteFile.writeFileByLines(writeFileString,"put(\"" + tempString + "\", " + df.format(rand) + ");\r");
				} catch (Exception e) {
					// TODO: handle exception
				}

			}

			// 遍历
			// while (stringTokenizer.hasMoreElements()) {
			// // 获取每个值
			// String wordValue = stringTokenizer.nextToken();
			// // 设置map输出的key值
			// WriteFile.writeFileByLines("E:/b.txt", wordValue + "," + "1");
			// }

			// System.out.println("line " + line + ": " + tempString);
			line++;
		}

		reader.close();

	}

	public static void main(String[] args) throws IOException {
		//title特征添加进去--高分数
		wordcount("E:/笔记学习/天池比赛/阿里云安全算法/切换数据后/title特征.txt",
				"E:/笔记学习/天池比赛/阿里云安全算法/切换数据后/title特征code.txt",
				"p2_fishurls_28_493_host");
	}

}
