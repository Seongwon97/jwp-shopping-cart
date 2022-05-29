package woowacourse.shoppingcart.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowacourse.shoppingcart.dao.MemberDao;
import woowacourse.shoppingcart.domain.member.Member;
import woowacourse.shoppingcart.dto.member.SignUpRequest;
import woowacourse.shoppingcart.exception.member.InvalidMemberException;

@Service
@Transactional
public class MemberService {

    private final MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void signUp(SignUpRequest request) {
        if (memberDao.existMemberByEmail(request.getEmail())) {
            throw new InvalidMemberException("중복되는 이메일이 존재합니다.");
        }

        Member member = new Member(request.getEmail(), request.getName(), request.getPassword());
        memberDao.save(member);
    }
}
