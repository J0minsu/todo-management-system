package moais.todoManage.msjo.config.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityUserInfo {

    private String id;
    private String password;
    private String name;
    private Long subjectSeq;

    private Long round;
    private Long centerSeq;

}