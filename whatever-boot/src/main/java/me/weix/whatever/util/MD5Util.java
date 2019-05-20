package me.weix.whatever.util;

import me.weix.whatever.common.enums.BizExceptionEnum;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.security.MessageDigest;
import java.util.Random;

/**
 * @author : weixiang
 * create at:  2019-05-20
 * @description: 加密工具
 */
public class MD5Util {

    /**
     * 默认密码盐长度
     */
    private static final int DEFAULT_SALT_LEN = 5;

    /**
     * 加盐参数
     */
    public final static String hashAlgorithmName = "MD5Util";

    /**
     * 循环次数
     */
    public final static int hashIterations = 1024;

    private static final String BASE_CHAR = "abcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * 获取随机字符,自定义长度
     *
     * @author fengshuonan
     * @Date 2018/3/18 21:55
     */
    public static String getRandomString() {
        return getRandomString(DEFAULT_SALT_LEN);
    }

    /**
     * 获取随机字符,自定义长度
     *
     * @author fengshuonan
     * @Date 2018/3/18 21:55
     */
    public static String getRandomString(Integer length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(BASE_CHAR.length());
            sb.append(BASE_CHAR.charAt(number));
        }
        return sb.toString();
    }

    /**
     * shiro密码加密工具类
     *
     * @param credentials 密码
     * @param saltSource  密码盐
     * @return
     */
    public static String md5(String credentials, String saltSource) {
        ByteSource salt = new Md5Hash(saltSource);
        return new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations).toString();
    }

    /**
     * md5加密(加盐)
     *
     * @author fengshuonan
     * @Date 2018/3/18 21:56
     */
    public static String md5Hex(String password, String salt) {
        return md5Hex(password + salt);
    }

    /**
     * md5加密(不加盐)
     *
     * @author fengshuonan
     * @Date 2018/3/18 21:56
     */
    public static String md5Hex(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5Util");
            byte[] bs = md5.digest(str.getBytes());
            StringBuffer md5StrBuff = new StringBuffer();
            for (int i = 0; i < bs.length; i++) {
                if (Integer.toHexString(0xFF & bs[i]).length() == 1) {
                    md5StrBuff.append("0").append(Integer.toHexString(0xFF & bs[i]));
                } else {
                    md5StrBuff.append(Integer.toHexString(0xFF & bs[i]));
                }
            }
            return md5StrBuff.toString();
        } catch (Exception e) {
            throw new RuntimeException(BizExceptionEnum.ENCRYPT_ERROR.getMessage());
        }
    }
}
