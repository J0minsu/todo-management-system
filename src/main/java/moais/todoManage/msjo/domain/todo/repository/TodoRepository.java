package moais.todoManage.msjo.domain.todo.repository;

import moais.todoManage.msjo.entity.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName    : moais.todoManage.msjo.domain.todo.repository
 * fileName       : TodoRepository
 * author         : ms.jo
 * date           : 2024. 6. 14.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 6. 14.        ms.jo       최초 생성
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
