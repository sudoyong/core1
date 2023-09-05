package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//스프링 컨테이너 생성 -> 스프링 빈 등록 -> 스프링 빈 의존관계 설정
//@ComponentScan: @Component 붙은 클래스를 찾아서 자동으로 스프링 빈에 등록
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //컴포넌트 스캔 대상 제외
)
public class AutoAppConfig {

}
