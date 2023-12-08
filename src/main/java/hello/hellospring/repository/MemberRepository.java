package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);//회원이 저장소에 저장
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);//회원이 저장되면 findById, Name으로 찾아오기 가능
    List<Member> findAll();//지금 까지 저장된 모든 회원 list 반환
}
