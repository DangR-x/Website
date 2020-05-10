package xiongjunmiao.top.Website.webtokenFilter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * getGroupId(@RequestBody AppGroupVo appGroupVo,@AuthUserInfo AppUser appUser)
 *对访问用户进行验证
 *
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthUserInfo {
    String value() default "";
}
/*
* controller 中使用
*
* @RequestMapping(value = "/list", method = RequestMethod.POST)
  public ResponseEntity<RestResponse<PageInfo>>
  getActsalUserList(@AuthUserInfo UserInfo userInfo,@Valid @RequestBody ActsalUserListVO actsalUserListVO) {

  }
* */