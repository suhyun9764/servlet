package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello",20);
        //when

        Member savedMember = memberRepository.save(member);

        //then

        memberRepository.findById(savedMember.getId());

        assertThat(member).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        //given
        Member member = new Member("member1",20);
        Member member1 = new Member("member2", 30);

        memberRepository.save(member);
        memberRepository.save(member1);
        //when
        List<Member> result = memberRepository.findAll();
        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(member1,member);
    }
}
