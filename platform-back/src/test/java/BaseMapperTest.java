import com.alibaba.fastjson.JSON;
import com.github.framework.starter.core.ApplicationContexts;
import com.github.platform.back.Application;
import com.github.platform.back.domain.po.UserPO;
import com.github.platform.back.mapper.UserMapper;
import com.github.platform.back.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class BaseMapperTest {


    static {
        ApplicationContexts.setProfileIfNotExists("dev");
    }

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;

    @Test
    public void test1() {
        int result = userService.deleteByUserName("");
        System.out.println(result);
    }

    @Test
    public void test() {
        UserPO userPO = userMapper.findByUserName("admin");
        System.out.println(JSON.toJSONString(userPO));

    }
}
