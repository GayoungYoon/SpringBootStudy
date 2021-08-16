package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); /**Optional : 리턴값이 null일 경우 optional 에 감싸서 반환해줌.*/
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
