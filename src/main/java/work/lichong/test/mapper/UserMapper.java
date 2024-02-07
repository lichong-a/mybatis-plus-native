package work.lichong.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import work.lichong.test.entity.User;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> getAllUser();

}
