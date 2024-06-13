package moais.todoManage.msjo.domain.member.service;

import moais.todoManage.msjo.domain.member.dto.req.MemberCreateReq;
import moais.todoManage.msjo.entity.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : moais.todoManage.msjo.domain.member.service
 * fileName       : MemberServiceTest
 * author         : ms.jo
 * date           : 2024. 6. 13.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 6. 13.        ms.jo       최초 생성
 */
@SpringBootTest
@Transactional(readOnly = true)
@ActiveProfiles("test")
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    public void 사용자는_생성이_돼야한다() throws Exception {

        //given
        MemberCreateReq request = new MemberCreateReq("msjo", "one", "qwe123!@#");
        //when
        Member member = memberService.createUser(request);
        //then
        assertEquals(request.getId(), member.getId());

    }

    /**
     * TODO 실패케이스 정의
     */

}