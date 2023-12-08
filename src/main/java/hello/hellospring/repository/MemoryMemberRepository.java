package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();//저장해줄 공간 Map(key,값)
    private static long sequence = 0L;//0,1,2즉, key값을 생성해주는 변수
    @Override
    public Member save(Member member) {
         member.setId(++sequence);//id값 중복안되게 지정
         store.put(member.getId(), member);//store에다가 id값 저장
         return member;

    }


    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))//member.getName이 인자로 넘어온 name이랑 같은지 확인해줌
                .findAny();//Lamda사용

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store Map에 있는 member들을 쭉 반환
    }

    public void clearStore(){
        store.clear();
    }
}
//여기까지 코드 짜고 이게 잘돌아가는지 어떻게 검증하지? ->--테스트 케이스작성