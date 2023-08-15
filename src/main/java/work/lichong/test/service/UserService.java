package work.lichong.test.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import work.lichong.test.entity.User;
import work.lichong.test.mapper.UserMapper;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
}
