package bizwiz.intranet.admin.controller;

import bizwiz.intranet.admin.dto.UserDto;
import bizwiz.intranet.common.base.ResponseResult;
import bizwiz.intranet.admin.service.user.UserService;
import bizwiz.intranet.common.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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

        log.info("dto ::: {} ", dto);

        userService.setUserTest(dto);
        return ResponseUtils.ConvertResponse();
    }

}
