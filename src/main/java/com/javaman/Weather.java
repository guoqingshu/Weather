package com.javaman;

import com.javaman.utils.RequestApiUtil;
import net.sf.json.JSONObject;

import java.util.Iterator;

/**
 * @program: WeatherMail
 * @classname: Weather
 * @description: 根据api获取天气信息
 * @author: Mr.Lee
 * @create: 2019-08-16 11:33
 **/
public class Weather {

    public static String getthreeday(String city){
        JSONObject jo = RequestApiUtil.result(city);
        JSONObject dayALL = jo.getJSONObject("future");
//        JSONObject adress=jo.getJSONObject("today");

        //展示future里面的信息
        System.out.println(dayALL.toString());

        StringBuilder sb = new StringBuilder();



        Iterator iterator = dayALL.keys();
        for (int i=0; i<4; ++i){
            String key =  (String) iterator.next();
            JSONObject day = dayALL.getJSONObject(key);
//            JSONObject adr=adress.getJSONObject(key);
            System.out.println(day.toString());

//            String cityy=adr.getString("city");
            String temperature = day.getString("temperature");
            String weather = day.getString("weather");
            String week = day.getString("week");
            String wind = day.getString("wind");
            String date = day.getString("date");

            String dayWeather = "地点："+city+";"
                    + "\t时间：" + date+";"
                    + "\t星期：" + week+";"
                    + "\t天气：" + weather+";"
                    + "\t温度：" + temperature+";"
                    + "\t风向：" + wind
                    + "\n";

            sb.append(dayWeather);
        }
        return sb.toString();
    }

//    public static void main(String[] args) {
//        get3day("武汉");
//    }

}