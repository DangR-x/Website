package xiongjunmiao.top.Website.uitl.sensitivefilterutils.util.encrypt.Test;

import org.junit.Test;
import xiongjunmiao.top.Website.uitl.sensitivefilterutils.util.encrypt.MD5;

import java.util.Random;

/**
 * Created by J on 2020/5/7 16:26
 */
public class MD5Test {

    public static void main(String[] args) {
        String md5 = MD5.getMD5("好日子");
        System.out.println(md5);
        boolean b = MD5.validateMD5( "123","202cb962ac59075b964b07152d234b70");
        System.out.println(b);
        String randomCode = MD5.getRandomCode(3);
        System.out.println("randomCode:"+randomCode);
    }
    @Test
    public void Test(){
        //生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
        int i = new Random().nextInt(10);
    }


}
