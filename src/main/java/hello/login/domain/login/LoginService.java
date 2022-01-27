package hello.login.domain.login;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password){
        /*Optional<Member> findMember = memberRepository.findByLoginId(loginId);
        Member member = findMember.get();

        if (member.getPassword().equals(password)) {
            return member;
        } else {
            return null;
        }*/

        return memberRepository.findByLoginId(loginId)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }
}
