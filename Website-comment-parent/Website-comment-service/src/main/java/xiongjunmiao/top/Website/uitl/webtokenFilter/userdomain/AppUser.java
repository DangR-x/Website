package xiongjunmiao.top.Website.uitl.webtokenFilter.userdomain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;

/**
 * @author admin
 * @ClassName: AppUser
 * @Description: 用户表 实体
 */
@Data
public class AppUser extends BaseEntity<AppUser> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 用户ID
	 * @author admin
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String userId;
	/**
	 * @Fields  :  昵称
	 * @author admin
	 */
	private String nickName;
	/**
	 * @Fields  :  头像
	 * @author admin
	 */
	private String userHead;
	/**
	 * @Fields  :  聊趣号
	 * @author admin
	 */
	private String userCode;
	/**
	 * @Fields  :  手机号
	 * @author admin
	 */
	private String phone;
	/**
	 * @Fields  :  密码
	 * @author admin
	 */
	private String password;
	/**
	 * @Fields  :  密码盐
	 * @author admin
	 */
	private String passwordSalt;
	/**
	 * @Fields  :  个性签名
	 * @author admin
	 */
	private String sign;

	/**
	 *  真实姓名
	 */
	private String realName;

	/**
	 *  身份证号码
	 */
	private String idCard;

	/**
	 * @Fields  :  用户类型 0普通用户 1 机器人 2 客服
	 * @author admin
	 */
	private String userType;
	/**
	 * @Fields  :  实名认证状态  0-未绑定 1-已绑定 2-已认证
	 * @author admin
	 */
	private String authStatus;
	/**
	 * @Fields  :  用户token
	 * @author admin
	 */
	private String tokenId;

	/**
	 *  用户状态
	 *  0-正常 1-已禁用
	 */
	private String status;

	/**
	 *  用户余额
	 */
	@Transient
	private BigDecimal money;

	/**
	 * 是否设置了支付密码
	 * 0 没有 1 有
	 */
	private int payPwdFlag;

	/**
	 *  手续费
	 */
	@Transient
	private String handRate;

	/**
	 * @Fields  :  客户ID
	 * @author admin
	 */
	private String custId;

	/**
	 *  php store sessionKey
	 */
	@Transient
	private String sessionKey;
	/**
	 *  php store sessionValue
	 */
	@Transient
	private String sessionValue;

	/**
	 *  yeepay is open account
	 */
	@Transient
	private Integer openAccountFlag;

	/**
	 *  设备id
	 */
	private String deviceId;

	@Transient
	private String fileUrlPre;
}