package com.mini.base.utils;

/**
 * Created by mumut on 2017/8/1.
 */

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RSAUtil {

    public static final String PUBLIC_KEY = "RSAPublicKey";
    public static final String PRIVATE_KEY = "RSAPrivateKey";
    private static final String KEY_ALGORITHM = "RSA";

    public static Optional<PrivateKey> toPrivateKey(String privateKey){
        byte[] keyBytes = new byte[0];
        try {
            keyBytes = Base64.decode(privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            return Optional.ofNullable(keyFactory.generatePrivate(pkcs8KeySpec));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static Optional<PublicKey> toPublicKey(String publicKey){
        byte[] keyBytes = new byte[0];
        try {
            keyBytes = Base64.decode(publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            return Optional.ofNullable(keyFactory.generatePublic(keySpec));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * 生成RSA的公钥和私钥
     */
    public static Map<String, Object> initKey() throws Exception{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);  //512-65536 & 64的倍数
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>();
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);

        return keyMap;
    }

    /**
     * 获得公钥
     */
    public static RSAPublicKey getpublicKey(Map<String, Object> keyMap){
        RSAPublicKey publicKey = (RSAPublicKey) keyMap.get(PUBLIC_KEY);
        return publicKey;
    }

    /**
     * 获得私钥
     */
    public static RSAPrivateKey getPrivateKey(Map<String, Object> keyMap){
        RSAPrivateKey privateKey = (RSAPrivateKey) keyMap.get(PRIVATE_KEY);
        return privateKey;
    }

    /**
     * 公钥加密
     */
    public static byte[] encrypt(byte[] data, PublicKey publicKey) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherBytes = cipher.doFinal(data);
        return cipherBytes;
    }

    /**
     * 私钥解密
     */
    public static byte[] decrypt(byte[] data, PrivateKey privateKey) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] plainBytes = cipher.doFinal(data);
        return plainBytes;
    }

    public static void main(String[] args) {
        try {
            Map<String, Object> map = initKey();
            byte[] encrypt = encrypt("23.07".getBytes(), getpublicKey(map));
            System.out.println("公钥：" + getpublicKey(map).toString());
            System.out.println("私钥：" + getPrivateKey(map).toString());
            System.out.println("加密后：" + new String(encrypt));
            byte[] decrypt = decrypt(encrypt, getPrivateKey(map));
            System.out.println("解密后：" + new String(decrypt));
        }catch (Exception ex) {

        }
    }
}