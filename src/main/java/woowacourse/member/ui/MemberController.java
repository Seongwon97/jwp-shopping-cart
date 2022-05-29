package woowacourse.member.ui;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import woowacourse.member.application.MemberService;
import woowacourse.member.dto.SignUpRequest;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody SignUpRequest request) {
        memberService.signUp(request);
    }
}
