package bizwiz.intranet.controller;

import bizwiz.intranet.dto.user.UserDto;
import bizwiz.intranet.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestController {

    private final UserService userService;

    @GetMapping("/test")
    public String index() {
        return "index.html";
    }

    @PostMapping("/save")
    public boolean setUserInfo(@RequestBody List<UserDto> dto) {

        boolean isOk = userService.setUserTest(dto);

        if (isOk) {
            return true;
        } else {
            return false;
        }

    }
}
