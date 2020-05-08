package xiongjunmiao.top.Website.uitl.webtokenFilter.userdomain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 注解名称：@JsonIgnore
 * 作用：在实体类向前台返回数据时用来忽略不想传递给前台的属性或接口。
 * Eg：User实体中会有字段password字段，当返回用户信息给前台的时候，当然是不希望将password值也一并返回。
 * 所以，这个时候可以在password属性上加上注解JsonIgnore或者，可以在User类上加上注解@JsonIgnoreProperties(value = "{password}")
 * @author qiaomengnan
 * @ClassName: BaseEntity
 * @Description: entity基类 所有的业务类 需要继承
 * @date 2018/1/7
 */
@Data
public abstract class BaseEntity<T> implements Entity,Serializable {

    private static final long serialVersionUID = 1L;

//    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmss)
    protected Date createTime;

    @JsonIgnore
    protected String creator;

//    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmss)
    protected Date updateTime;

    @JsonIgnore
    protected String updater;

    @JsonIgnore
    protected Integer delFlag;

    /**
     * @Fields  : 用于保存上一次数据库的更新时间,在更新时做排他处理
     * @Transient  在持久化到数据库的时候忽略掉该字段
     * @author qiaomengnan
     */
    @JsonIgnore
    @Transient
    protected Date updateLastTime;

}
