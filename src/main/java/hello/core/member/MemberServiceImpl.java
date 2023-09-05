package hello.core.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component: 스프링 빈 등록 대상
//@RequiredArgsConstructor: final 키워드가 붙은 필드를 모아서 생성자를 자동으로 생성
@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    //@Autowired: 의존관계 자동 등록
//    @Autowired
//    public MemberServiceImpl(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
