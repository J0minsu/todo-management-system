package moais.todoManage.msjo.config.security;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SecurityDetailsService implements UserDetailsService {

    DataSource dataSource;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        SecurityUserInfo jwtSecurityUserInfo = getJwtSecurityUserInfo(id);

        // 추후 subject Table에 권한이 세분화되면 jwtSzecurityUserInfo에서 꺼내서 사용
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        /*List<SimpleGrantedAuthority> authorities = UserType.SUBJECT.getRoles()
                .stream().map(SimpleGrantedAuthority::new).toList();*/

        return new SecurityUserDetails(jwtSecurityUserInfo, authorities);
    }

    private SecurityUserInfo getJwtSecurityUserInfo(String id) {

        try {
            return new JdbcTemplate(this.dataSource)
                    .queryForObject(
                            """
                                     SELECT 
                                         s.id,
                                         s.password,
                                         s.name, 
                                         s.subject_seq as subjectSeq,
                                         s.round,
                                         s.center_seq
                                     FROM subject s
                                     WHERE s.id = ?
                                     AND s.is_active = 1
                                """,
                            new BeanPropertyRowMapper<>(SecurityUserInfo.class),
                            id);
        } catch (EmptyResultDataAccessException e) {
            log.info("Not Exist or Not active subject in DB - insert id :: {}", id);
            throw new UsernameNotFoundException("등록된 대상자가 없습니다.");
        }

    }

}
