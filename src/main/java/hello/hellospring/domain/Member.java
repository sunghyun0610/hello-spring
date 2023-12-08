package hello.hellospring.domain;

public class Member {
    private Long id;//고객이 정하는 id가아니라 데이터를 구분하기 위해서 시스템에서 저장하는 id
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
