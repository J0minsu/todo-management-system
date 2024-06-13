package moais.todoManage.msjo.entity.domain;

import com.google.common.collect.Lists;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import moais.todoManage.msjo.entity.common.audit.BaseTime;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

/**
 * packageName    : moais.todoManage.msjo.entity.domain
 * fileName       : TodoHistory
 * author         : ms.jo
 * date           : 2024. 6. 13.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 6. 13.        ms.jo       최초 생성
 */
@Entity
@Getter
@DynamicUpdate
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "todo")
@Comment("할 일 변경 내역")
public class TodoHistory extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("할 일 변경 내역 순차번호")
    Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_seq")
    @Comment("할 일 순차번호")
    Todo todo;

}
