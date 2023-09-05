package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component: 스프링 빈 등록 대상
//@Qualifier: 매칭 타입 결과가 2개 이상인 경우
//@Primary: 매칭 타입 결과가 2개 이상인 경우, Primary 보다 Qualifier가 우선 순위를 가짐
@Component
@Primary
//@Qualifier("rateDiscountPolicy")
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
