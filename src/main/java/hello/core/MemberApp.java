package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //스프링 컨테이너 생성 -> 스프링 빈 등록 -> 스프링 빈 의존관계 설정
        //ApplicationContext: 스프링 컨테이너
        //스프링 컨테이너는 @Configuration이 붙은 AppConfig를 구성 정보로 사용
        //@Bean이라 적힌 메서드를 모두 호출해 반환된 객체를 스프링 컨테이너에 등록
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member ==> " + member.getName());
        System.out.println("find member ==> " + findMember.getName());
    }
}
