package moais.todoManage.msjo.entity.domain;

import com.google.common.collect.Lists;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import moais.todoManage.msjo.entity.common.audit.BaseTime;
import moais.todoManage.msjo.entity.common.enums.TodoStatus;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * packageName    : moais.todoManage.msjo.entity.domain
 * fileName       : Todo
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
@ToString(exclude = "member")
@Comment("할 일")
public class Todo extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("할 일 순차번호")
    Long seq;

    @Enumerated(EnumType.STRING)
    @Comment("할 일 상태")
    TodoStatus status;

    @Comment("내용")
    String contents;

    @Comment("수행 예정 일시")
    LocalDateTime scheduledAt;

    @ManyToOne
    @JoinColumn(name = "user_seq")
    @Comment("사용자")
    Member member;

    @OneToMany(mappedBy = "todo", fetch = FetchType.LAZY, orphanRemoval = false)
    List<TodoHistory> histories = Lists.newArrayList();


    /**
     * TODO history 관리를 어떻게 할 지 고민 중. 남긴다면 history 생성은 이 곳에서만.
     * @return
     */

    public boolean toTODO() {
        TodoStatus status = TodoStatus.TODO;
        this.status = status;

        return true;
    }

    public boolean toProgress() {
        TodoStatus status = TodoStatus.IN_PROGRESS;
        this.status = status;

        return true;
    }

    public boolean toDone() {
        TodoStatus status = TodoStatus.DONE;
        this.status = status;

        return true;
    }

    public boolean toPending() {
        TodoStatus status = TodoStatus.PENDING;

        if(Objects.equals(this.status, TodoStatus.IN_PROGRESS)) {
            this.status = TodoStatus.PENDING;

            return true;
        }

        return false;
    }

}
