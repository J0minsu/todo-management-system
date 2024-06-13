package moais.todoManage.msjo.config.security;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Slf4j
public class SecurityUserDetails implements UserDetails {

    private final SecurityUserInfo jwtSecurityUserInfo;
    private final List<? extends GrantedAuthority> authorities;

    public SecurityUserDetails(SecurityUserInfo jwtSecurityUserInfo, List<? extends GrantedAuthority> authorities) {
        this.jwtSecurityUserInfo = jwtSecurityUserInfo;
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return jwtSecurityUserInfo.getId();
    }

    @Override
    public String getPassword() {
        return jwtSecurityUserInfo.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getName() {
        return jwtSecurityUserInfo.getName();
    }

    public Long getSubjectSeq() {
        return jwtSecurityUserInfo.getSubjectSeq();
    }


    public Long getCenterSeq() {
        return jwtSecurityUserInfo.getCenterSeq();
    }

    public Long getRound() {
        return jwtSecurityUserInfo.getRound();
    }

    /**
     * 필요시 재정의(기본 RETURN TRUE)
     */
    @Override
    public boolean isAccountNonExpired() {
        return Boolean.TRUE;
    }

    @Override
    public boolean isAccountNonLocked() {
        return Boolean.TRUE;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return Boolean.TRUE;
    }

    @Override
    public boolean isEnabled() {
        return Boolean.TRUE;
    }

}
