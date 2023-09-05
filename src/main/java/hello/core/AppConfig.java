package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스프링 컨테이너 생성 -> 스프링 빈 등록 -> 스프링 빈 의존관계 설정
//@Configuration 제거하면 스프링 빈은 생성 되지만 싱글톤을 보장하지 않음
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("Call ==> AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call ==> AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call ==> AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("Call ==> AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }
}
