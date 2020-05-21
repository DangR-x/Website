package xiongjunmiao.top.Website.domain;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by J on 2020/5/20 14:01
 */
public class AsUserDetails implements UserDetails {

    private User user;
    //需要过滤的路径
    private List<AdminResource> resourceList;

    public AsUserDetails(User user, List<AdminResource> resourceList) {
        this.user = user;
        this.resourceList = resourceList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<AdminResource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<AdminResource> resourceList) {
        this.resourceList = resourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的角色
        return resourceList.stream()
                .map(role ->new SimpleGrantedAuthority(role.getId()+":"+role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
    //该用户是否在使用
    @Override
    public boolean isEnabled() {
        return false;
    }
}
