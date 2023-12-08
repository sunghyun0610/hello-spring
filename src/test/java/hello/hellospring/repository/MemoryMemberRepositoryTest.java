package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository= new MemoryMemberRepository();
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }//Test가 끝 날때마다 repository를 지운다.

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

        Member result=repository.findByName("spring2").get();

        Assertions.assertThat(result).isEqualTo(member2);

    }

    @Test
    public void findAll(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);

    }

}
