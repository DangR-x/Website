package xiongjunmiao.top.Website.encryptionutls;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * @author Administrator
 * 日期 2018/3/21
 * 描述
 */

public class H5AESCipher {

    /**
     * 算法/模式/填充
     **/
    private static final String CIPHERMODE = "AES/ECB/PKCS5Padding";
    private static final String IV = "9abgkf10v46278xc";
    private static final String PASSWORD = "8226a23e1390894b";

    private static SecretKeySpec createKey(String key) {
        byte[] data = null;
        if (key == null) {
            key = "";
        }
        StringBuffer sb = new StringBuffer(16);
        sb.append(key);
        while (sb.length() < 16) {
            sb.append("0");
        }
        if (sb.length() > 16) {
            sb.setLength(16);
        }

        try {
            data = sb.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new SecretKeySpec(data, "AES");
    }

    private static IvParameterSpec createIV(String password) {
        byte[] data = null;
        if (password == null) {
            password = "";
        }
        StringBuffer sb = new StringBuffer(16);
        sb.append(password);
        while (sb.length() < 16) {
            sb.append("0");
        }
        if (sb.length() > 16) {
            sb.setLength(16);
        }

        try {
            data = sb.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new IvParameterSpec(data);
    }

    /**
     * 加密字节数据
     **/
    public static byte[] encrypt(byte[] content, String password, String iv) {
        try {
            SecretKeySpec key = createKey(password);
            Cipher cipher = Cipher.getInstance(CIPHERMODE);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密(结果为16进制字符串)
     **/
    public static String encrypt(String content) {
        byte[] data = null;
        try {
            data = content.getBytes("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        data = encrypt(data, PASSWORD, IV);
        String result = HexUtil.byte2Base64StringFun(data);
        //注意：linux环境下加密时，会自动补\r \n到加密数据里面
        //str = str.replaceAll("\r\n", "");
        result = result.replaceAll("\n", "");
        return result;
    }

    /**
     * 解密
     **/
    public static String decrypt(String content) {
        String result = decrypt(content, PASSWORD, IV);
        return result;
    }

    /**
     * 解密字节数组
     **/
    public static byte[] decrypt(byte[] content, String password, String iv) {
        try {
            SecretKeySpec key = createKey(password);
            Cipher cipher = Cipher.getInstance(CIPHERMODE);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     **/
    public static String decrypt(String content, String password, String iv) {
        byte[] data = null;
        try {
            data = HexUtil.base64String2ByteFun(content);
        } catch (Exception e) {
            e.printStackTrace();
        }

        data = decrypt(data, password, iv);
        if (data == null)
            return null;
        String result = null;
        try {
            result = new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
