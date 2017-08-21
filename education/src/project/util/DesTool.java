package project.util;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * 数据加密解密类
 * @author Administrator
 *
 */
public class DesTool {

	private byte[] desKey;     
    
    
    //解密数据     
    public static String decrypt(String message,String key) throws Exception {     
              
            byte[] bytesrc =convertHexString(message);        
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");         
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));        
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");        
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);        
            IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));     
                     
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);           
               
            byte[] retByte = cipher.doFinal(bytesrc);          
            return new String(retByte);      
    }     
    
    public static byte[] encrypt(String message, String key)     
            throws Exception {     
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");     
    
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));     
    
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");     
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);     
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));     
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);     
    
        return cipher.doFinal(message.getBytes("UTF-8"));     
    }     
         
    public static byte[] convertHexString(String ss)      
    {      
    byte digest[] = new byte[ss.length() / 2];      
    for(int i = 0; i < digest.length; i++)      
    {      
    String byteString = ss.substring(2 * i, 2 * i + 2);      
    int byteValue = Integer.parseInt(byteString, 16);      
    digest[i] = (byte)byteValue;      
    }      
    
    return digest;      
    }      
    
    
    public static void main(String[] args) throws Exception {     
        String key = "fjyxtedu";     
        String value="un=fjadmin&uid=149711&idno=12312312";     
        String jiami=java.net.URLEncoder.encode(value, "utf-8").toLowerCase();     
             
        System.out.println("加密数据:"+jiami);     
        String a=toHexString(encrypt(jiami, key)).toUpperCase();     
             
        System.out.println("加密后的数据为:"+a);     
        String b=java.net.URLDecoder.decode(decrypt(a,key), "utf-8");     
        System.out.println("解密后的数据:"+b);     
    
    }     
    
         
    public static String toHexString(byte b[]) {     
        StringBuffer hexString = new StringBuffer();     
        for (int i = 0; i < b.length; i++) {     
            String plainText = Integer.toHexString(0xff & b[i]);     
            if (plainText.length() < 2)     
                plainText = "0" + plainText;     
            hexString.append(plainText);     
        }     
             
        return hexString.toString();     
    } 
	
}


class CryptoTools {  
	  
    private static final byte[] DESkey = { (byte) 0x15, (byte) 0xE7,  
            (byte) 0xA1, (byte) 0x22, (byte) 0x96, (byte) 0x8B, (byte) 0x24,  
            (byte) 0xFA };// 设置密钥，略去  
  
    private static final byte[] DESIV = { (byte) 0xCE, (byte) 0x35, (byte) 0x5,  
            (byte) 0xD, (byte) 0x98, (byte) 0x91, (byte) 0x8, (byte) 0xA };// 设置向量，略去  
  
    static AlgorithmParameterSpec iv = null;// 加密算法的参数接口，IvParameterSpec是它的一个实现  
    private static Key key = null;  
  
    public CryptoTools() throws Exception {  
        DESKeySpec keySpec = new DESKeySpec(DESkey);// 设置密钥参数  
        iv = new IvParameterSpec(DESIV);// 设置向量  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂  
        key = keyFactory.generateSecret(keySpec);// 得到密钥对象  
  
    }  
  
    public String encode(String data) throws Exception {  
        Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");// 得到加密对象Cipher  
        enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// 设置工作模式为加密模式，给出密钥和向量  
        byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));  
        BASE64Encoder base64Encoder = new BASE64Encoder();  
        return base64Encoder.encode(pasByte);  
    }  
  
    public String decode(String data) throws Exception {  
        Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");  
        deCipher.init(Cipher.DECRYPT_MODE, key, iv);  
        BASE64Decoder base64Decoder = new BASE64Decoder();  
        byte[] pasByte = deCipher.doFinal(base64Decoder.decodeBuffer(data));  
        return new String(pasByte, "UTF-8");  
    }  
  
    public static void main(String[] args) throws Exception {  
  
        CryptoTools tools = new CryptoTools();  
        System.out.println("加密:" + tools.encode("测试"));  
        System.out.println("解密:" + tools.decode(tools.encode("测试")));  
    }  
  
}

