package com.bluecloud.vnet.sdk.java.util;

import java.io.*;

public class JsonReadFile {


    /**
     * @param jsonFilePath json 文件路径
     * @return java.lang.String 返回json文件内容
     * @throws
     * @author dongliping
     * @description 读取json文件
     * @date 2022/3/28
     * @todo
     */
    public static String readJsonFile(String jsonFilePath) {
        String jsonStr = "";
        try {
            File jsonFile = new File(jsonFilePath);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {
        String path = "D:\\research_evaluation_new.json";
        String s = readJsonFile(path);
        System.out.println("s = " + s);
    }
}