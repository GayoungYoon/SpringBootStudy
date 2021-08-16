package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    private MemberService memberService = new MemberService();


    @Test
    void 회원가입() {
        //given
        Member member1 = new Member();
        member1.setName("hello");
        //when
        Long saveId = memberService.join(member1);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member1.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복회원예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);


        try{
            memberService.join(member2);
        }catch(IllegalStateException e){

        }
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}