package work.lichong.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import work.lichong.test.service.UserService;

@RestController
public class TestController {

    private final UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String test() {
        return userService.getById(1L).toString();
    }
}
