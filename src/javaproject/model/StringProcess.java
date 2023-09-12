package javaproject.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class StringProcess {
    public String calc(String secret){      //SHA哈希加密
        String key="MD5";
        BigInteger sha =null;
        byte[] inputData = secret.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(key);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sha.toString(32);
    }

    public String randGenerate(){           //随机生成长度为10的字符串
        int length = 10; // 生成的字符串长度
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        return randomString;
    }

    public void mailSend(String secret, String target){     //发送邮件到指定邮箱
        //	账号信息
        String username = "1443524956@qq.com";	//邮箱发送账号
        String password = "uzlkqgndnwujigdi";	//邮箱授权码

        //	创建一个配置文件
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.qq.com");	    //SMTP主机名
        props.put("mail.smtp.port", "587");				//主机端口号
        props.put("mail.smtp.auth", "true");			//是否需要用户认证
        props.put("mail.smtp.starttls.enale", "true");	//启用TLS加密

        //创建会话对象
        Session session = Session.getInstance(props,new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // TODO Auto-generated method stub
                return new PasswordAuthentication(username,password);
            }
        });

        try{
            MimeMessage message = new MimeMessage(session);
            message.setSubject("重置密码");
            message.setText("重置的密码为:"+secret);
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(target));

            //  发送
            Transport.send(message);
            System.out.println("邮件发送成功");
        }
        catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("邮件发送失败！");
        }
    }

    public ArrayList<ArrayList<String>> stringSlice(String history){    //切割字符串到要求形式
        ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
        String [] shopRow=history.split("[&,]");
        int cnt=0;
        for (int i=0;i<shopRow.length;){
            ArrayList<String> comRow=new ArrayList<String>();
            for (int j=0;j<3;j++){
                comRow.add(shopRow[i]);
                i++;
            }
            res.add(comRow);
        }
        return res;
    }
}
