package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {

    MemberRepository repository= new MemoryMemberRepository();

    @Test
    public void save(){
        Member member= new Member();
        member.setName("spring");

        repository.save(member);
        Member result= repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2=new Member();//shift +f6 ->전체 rename
        member2.setName("spring2");
        repository.save(member2);
    }
}
