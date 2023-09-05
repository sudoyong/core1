package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//스프링 빈 이벤트 라이프사이클
//스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료
//생성자 주입 경우 스프링 빈 생성시 의존관계도 같이 주입
public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url ==> " + url);
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect ==> " + url);
    }

    public void call(String message) {
        System.out.println("call ==> " + url + ", message ==> " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close ==> " + url);
    }

    //의존관계 주입이 끝나면 호출
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//    }

    //스프링이 종료할 때 호출
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }

    //코드가 아니라 설정 정보를 사용하기 때문에 외부 라이브러리에도 초기화, 종료 메서드를 적용할 수 있음
    @PostConstruct
    public void init() {
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() throws Exception {
        disconnect();
    }
}
