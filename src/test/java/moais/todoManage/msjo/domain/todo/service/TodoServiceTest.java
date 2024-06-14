package moais.todoManage.msjo.domain.todo.service;

import moais.todoManage.msjo.domain.member.dto.req.MemberCreateReq;
import moais.todoManage.msjo.domain.member.service.MemberService;
import moais.todoManage.msjo.domain.todo.dto.req.TodoCreateReq;
import moais.todoManage.msjo.entity.domain.Member;
import moais.todoManage.msjo.entity.domain.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : moais.todoManage.msjo.domain.todo.service
 * fileName       : TodoServiceTest
 * author         : ms.jo
 * date           : 2024. 6. 14.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 6. 14.        ms.jo       최초 생성
 */

@SpringBootTest
@Transactional(readOnly = true)
@ActiveProfiles("test")
class TodoServiceTest {

    @Autowired MemberService memberService;
    @Autowired TodoService todoService;

    @Test
    public void 사용자는_TODO를_N개_생성할_수_있어야_한다() throws Exception {
    
        MemberCreateReq request = new MemberCreateReq("msjo", "one", "qwe123!@#");
        //when
        Member member = memberService.createUser(request);

        Todo todo1 = todoService.createTodo(member,
                new TodoCreateReq("패널티킥 30번 차기", "실내 축구장 이용", LocalDateTime.now().plusDays(1))
        );

        Todo todo2 = todoService.createTodo(member,
                new TodoCreateReq("패널티킥 30번 차기", "실내 축구장 이용", LocalDateTime.now().plusDays(1))
        );

        //then
        assertNotNull(todo1);
        assertNotNull(todo2);

    }
    
    @Test
    public void 사용자는_자신이_가장_최근에_작성한_TODO를_조회할_수_있어야_한다() throws Exception {
    
        MemberCreateReq request = new MemberCreateReq("msjo", "one", "qwe123!@#");
        //when
        Member member = memberService.createUser(request);

        todoService.createTodo(member,
                new TodoCreateReq("패널티킥 30번 차기", "실내 축구장 이용", LocalDateTime.now().plusDays(1))
        );

        Thread.sleep(1000 * 1);

        Todo todo2 = todoService.createTodo(member,
                new TodoCreateReq("패널티킥 40번 차기", "실내 축구장 이용", LocalDateTime.now().plusDays(1))
        );

        Todo findlastestTodo = todoService.findLastestTodo(member);

        assertEquals(findlastestTodo.getContents(), todo2.getContents());

        //then
    
    }
    
    @Test
    public void 사용자는_자신이_작성한_TODO의_목록을_조회할_수_있어야_한다() throws Exception {
    
        //given
        
        //when
        
        //then
    
    }
    
    @Test
    public void TODO_상태의_TODO는_PENDING을_제외한_어떤_상태로도_변경_가능해야_한다() throws Exception {
    
        //given
        
        //when
        
        //then
    
    }

    @Test
    public void IN_PROGRESS_상태의_TODO는_어떤_상태로도_변경_가능해야_한다() throws Exception {

        //given

        //when

        //then

    }

    @Test
    public void DONE_상태의_TODO는_PENDING을_제외한_어떤_상태로도_변경_가능해야_한다() throws Exception {

        //given

        //when

        //then

    }

    @Test
    public void PENDING_상태의_TODO는_어떤_상태로도_변경_가능해야_한다() throws Exception {

        //given

        //when

        //then

    }
}