package com.select.utils;

public class Tools {
    //工具类
    //获取一个随机的文件名称
    public synchronized  static String getRndFilename(){
        return String.valueOf(System.currentTimeMillis());
    }

    //获取到文件扩展名
    public synchronized  static String  getFileExtName(String filename){
        int p = filename.indexOf(".");
        return filename.substring(p);
    }

}
