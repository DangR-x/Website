package xiongjunmiao.top.Website.webtokenFilter;

import org.junit.Test;
import org.springframework.beans.BeanUtils;
import xiongjunmiao.top.Website.domain.AppUser;

import java.util.UUID;

import static xiongjunmiao.top.Website.sensitivefilterutils.util.StringUtils.isTrimBlank;

/**
 * Created by J on 2020/5/8 10:34
 */
public class TokenTest {

    public static void main(String[] args) {
        String requestUri="/web";
        String notAuthUrl="/**/web";
        int i = notAuthUrl.indexOf("/**");
        String notAuthUrlTemp = notAuthUrl.replace("/**", "");
        boolean b = requestUri.startsWith(notAuthUrlTemp);
        System.out.println(isTrimBlank(""));
    }

    @Test
    public void getEntity(){

        AppUser appUser = new AppUser();
        appUser.setNickName("哈哈哈");
        Class<? extends AppUser> aClass = appUser.getClass();
        try {
            AppUser appUser1 = aClass.newInstance();
            System.out.println(appUser1);
            BeanUtils.copyProperties(appUser,appUser1);
            System.out.println(appUser1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void UUIDTest(){
        String uuid = UUID.randomUUID().toString().replace("-","");
        System.out.println(uuid);
    }

}
