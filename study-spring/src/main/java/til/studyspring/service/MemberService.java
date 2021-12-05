package til.studyspring.service;

import til.studyspring.domain.Member;
import til.studyspring.repository.MemberRepository;
import til.studyspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /*
    * 회원가입
    * */
    public Long join(Member member){
        //중복 이름 X
        vaildateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void vaildateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이름입니다.");
                });
    }

    /*
        Service단 비지니스 용어
        repository 서비스 보단 기계적으로 개발적인 용어
    * 전체 회원 조회
    * */
    public List<Member> findMembers(){
       return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
