package com.javaman;


import com.javaman.utils.SendmailUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: WeatherMail
 * @classname: Mail
 * @description: java邮件发送
 * @author: Mr.Lee
 * @create: 2019-08-16 11:33
 **/
public class Mail {
    private static String toEmailAddress = "815116684@qq.com";
    private static String emailTitle = "春蕾学员培训-天气预报 郭庆树"+"\t";
    private static String emailContent = "java 发送邮件内容";

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        emailTitle+=sdf.format(new Date());
        try {
            emailContent = Weather.getthreeday("黄石");
            SendmailUtil.sendEmail(toEmailAddress, emailTitle, emailContent);
        } catch (Exception e) {
            e.printStackTrace();
                    }
    }
}
