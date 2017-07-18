package common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Author: Tennyson
 * Date Time: 2016/1/13 21:17
 * Mail:xing_wang@cxsoft.com
 * Desc:手动修改
 */
public class EncryptUtil {
    public static final String KEY_SHA = "SHA";
    public static final String KEY_MD5 = "MD5";
    /**
     * MAC算法可选以下多种算法
     *
     * <pre>
     * HmacMD5
     * HmacSHA1
     * HmacSHA256
     * HmacSHA384
     * HmacSHA512
     * </pre>
     */
    public static final String KEY_MAC = "HmacMD5";

    /**
     * demo
     * @param args
     * @throws Exception
     */
    public static void main(String[]args) throws Exception {
        String inputStr = "简单加密";
        System.err.println("原文:" + inputStr);

        byte[] inputData = inputStr.getBytes();
        String code = encryptBASE64(inputData);

        System.err.println("BASE64加密后:" + code);

        byte[] output = new byte[0];
        try {
            output = decryptBASE64(code);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String outputStr = new String(output);

        System.err.println("BASE64解密后:" + outputStr);



        String key = initMacKey();
        System.err.println("Mac密钥:" + key);

        BigInteger md5 = new BigInteger(encryptMD5(inputData));
        System.err.println("MD5:" + md5.toString(16));

        BigInteger sha = new BigInteger(encryptSHA(inputData));
        System.err.println("SHA:" + sha.toString(32));

        BigInteger mac = new BigInteger(encryptHMAC(inputData, inputStr));
        System.err.println("HMAC:" + mac.toString(16));


    }

    /**
     * BASE64加密
     * @param key
     * @return
     */
    public static String encryptBASE64(byte[] key){
        return (new BASE64Encoder().encodeBuffer(key));
    }

    /**
     * BASE64加密
     * @param key
     * @return
     */
    public static byte[] decryptBASE64(String key) throws IOException {
        return (new BASE64Decoder().decodeBuffer(key));
    }

    /**
     * MD5
     * @param data
     * @return
     */
    public static byte[] encryptMD5(byte[] data){
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance(KEY_MD5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md5.update(data);
        return md5.digest();
    }

    /**
     * SHA
     * @param data
     * @return
     */
    public static byte[] encryptSHA(byte[] data){
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance(KEY_SHA);
            sha.update(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sha.digest();
    }

    /**
     * 初始化HMAC密钥
     * @return
     */
    public static String initMacKey(){
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance(KEY_MAC);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecretKey secretKey = keyGenerator.generateKey();
        return encryptBASE64(secretKey.getEncoded());
    }

    public static byte[] encryptHMAC(byte[] data, String key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(decryptBASE64(key),KEY_MAC);
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        return mac.doFinal(data);
    }
}
