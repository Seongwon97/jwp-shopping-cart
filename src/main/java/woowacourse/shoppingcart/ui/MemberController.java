package woowacourse.shoppingcart.ui;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import woowacourse.shoppingcart.application.MemberService;
import woowacourse.shoppingcart.dto.member.SignUpRequest;

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
