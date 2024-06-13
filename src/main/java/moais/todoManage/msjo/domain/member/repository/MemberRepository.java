package moais.todoManage.msjo.domain.member.repository;

import moais.todoManage.msjo.entity.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName    : moais.todoManage.msjo.domain.member.repository
 * fileName       : MemberRepository
 * author         : ms.jo
 * date           : 2024. 6. 13.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 6. 13.        ms.jo       최초 생성
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
