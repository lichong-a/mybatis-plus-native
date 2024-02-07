package work.lichong.test.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import work.lichong.test.entity.User;
import work.lichong.test.mapper.UserMapper;

import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Resource
    UserMapper userMapper;

    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

}
