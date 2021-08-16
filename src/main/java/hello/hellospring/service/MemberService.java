package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    
    /**
     * 회원가입
     * */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원은 안된다.
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //Optional<Member> result = memberRepository.findById(member.getName());
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { //result를 optional로 쌓지 않고//optional이기 떄문에 이 메소드를 사용할 수 있음.
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
    * 전체 회원 조회
    * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne (Long memberId){
        return memberRepository.findById(memberId);
    }


}
