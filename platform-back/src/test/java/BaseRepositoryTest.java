import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.github.framework.starter.core.ApplicationContexts;
import com.github.platform.back.Application;
import com.github.platform.back.domain.po.UserPO;
import com.github.platform.back.repository.UserRepository;
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
public class BaseRepositoryTest {

    static {
        ApplicationContexts.setProfileIfNotExists("div");
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1() {
        UserPO userPO = userRepository.findOne(1);

        System.out.println(JSON.toJSONString(userPO));
    }
}
