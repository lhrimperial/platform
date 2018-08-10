import com.alibaba.fastjson.JSON;
import com.github.framework.starter.core.ApplicationContexts;
import com.github.platform.back.Application;
import com.github.platform.back.domain.entity.ResourceEntity;
import com.github.platform.back.domain.entity.RoleEntity;
import com.github.platform.back.domain.entity.UserEntity;
import com.github.platform.back.repository.ResourceRepository;
import com.github.platform.back.repository.RoleRepository;
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

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Test
    public void test3() {
        ResourceEntity resourcePO = resourceRepository.findOne(1);
        System.out.println(JSON.toJSONString(resourcePO));

    }

    @Test
    public void test2() {
        RoleEntity rolePO = roleRepository.findOne(1);
        System.out.println(JSON.toJSONString(rolePO));
    }

    @Test
    public void test1() {
        UserEntity userPO = userRepository.findOne(1);

        System.out.println(JSON.toJSONString(userPO));
    }
}
