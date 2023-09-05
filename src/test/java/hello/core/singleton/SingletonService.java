package hello.core.singleton;

//싱글톤 패턴
//클래스의 인스턴스가 딱 1개만 생성되는 것을 보장
public class SingletonService {

    //static 영역에 객체를 딱 1개만 생성
    private static final SingletonService instance = new SingletonService();

    //public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용
    public static SingletonService getInstance() {
        return instance;
    }

    //생성자를 private으로 선언하여 외부에서 객체 생성을 못하게 막음
    private SingletonService() {

    }
}
