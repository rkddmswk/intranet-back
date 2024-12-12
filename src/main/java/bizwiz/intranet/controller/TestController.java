package bizwiz.intranet.controller;

import bizwiz.intranet.common.base.ResponseResult;
import bizwiz.intranet.dto.user.UserDto;
import bizwiz.intranet.service.user.UserService;
import bizwiz.intranet.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/list")
    public ResponseEntity<ResponseResult> getUserInfo() {

        List<UserDto> data = userService.getUserInfo();

        return ResponseUtils.ConvertResponse(data);
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseResult> setUserInfo(@RequestBody List<UserDto> dto) {

        userService.setUserTest(dto);
        return ResponseUtils.ConvertResponse();
    }

}
