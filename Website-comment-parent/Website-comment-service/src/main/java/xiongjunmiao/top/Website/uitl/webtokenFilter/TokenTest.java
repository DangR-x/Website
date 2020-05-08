package xiongjunmiao.top.Website.uitl.webtokenFilter;

import xiongjunmiao.top.Website.uitl.sensitivefilterutils.util.StringUtils;

import static xiongjunmiao.top.Website.uitl.sensitivefilterutils.util.StringUtils.isTrimBlank;

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
}
