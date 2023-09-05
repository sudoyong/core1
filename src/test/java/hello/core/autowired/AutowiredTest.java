package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        //자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
        @Autowired(required = false)
        public void setNoBean1(Member NoBean1) {
            System.out.println("setNoBean1 ==> " + NoBean1);
        }

        //자동 주입할 대상이 없으면 null로 입력
        @Autowired
        public void setNoBean2(@Nullable Member NoBean2) {
            System.out.println("setNoBean2 ==> " + NoBean2);
        }

        //자동 주입할 대상이 없으면 Optional.empty로 입력
        @Autowired
        public void setNoBean3(Optional<Member> NoBean3) {
            System.out.println("setNoBean3 ==> " + NoBean3);
        }
    }

}
