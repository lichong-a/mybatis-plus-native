package work.lichong.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import work.lichong.test.mapper.UserMapper;

@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/test")
    public String test() {
        return userMapper.selectById(1L).toString();
    }
}
