package xiongjunmiao.top.Website.uitl.webtokenFilter.userdomain;

import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: Entity
 * @Description: entity接口基类
 * @date 2018/1/7LmsServiceException
 */
public interface Entity {

    String getCreator();

    String getUpdater();

    Date getUpdateTime();

    Date getUpdateLastTime();

    Date getCreateTime();

    Integer getDelFlag();

}
