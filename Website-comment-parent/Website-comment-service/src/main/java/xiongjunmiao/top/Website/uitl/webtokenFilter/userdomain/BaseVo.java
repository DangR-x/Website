package xiongjunmiao.top.Website.uitl.webtokenFilter.userdomain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: BaseVo
 * @Description:
 * @date 2018/2/5
 */
@Slf4j
@Data
public abstract class BaseVo<T> implements Vo,Serializable {

    private static final long serialVersionUID = 1L;

//    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmssSSS)
    protected Date createTime;

//    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmss)
    public Date getCreateTime(){
        return createTime;
    }

    @JsonIgnore   //在实体类向前台返回数据时用来忽略不想传递给前台的属性或接口
    protected String creator;

//    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmssSSS)
    protected Date updateTime;

    @JsonIgnore
    protected String updater;

    @JsonIgnore
    protected Integer delFlag;

    @JsonIgnore     //在实体类向前台返回数据时用来忽略不想传递给前台的属性或接口
    @JSONField(serialize = false)   //忽略掉,隐藏掉需要的字段
    public T getEntity(){
        try{
            //从泛型获取真实类型
            Class clazz = (Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            return EntityUtils.getEntity(this,(T)clazz.newInstance());
        }catch (IllegalAccessException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }catch (InstantiationException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * @Fields  : 用于保存上一次数据库的更新时间,在更新时做排他处理
     * @author qiaomengnan
     */
    @JsonIgnore
    protected Date updateLastTime;

}
