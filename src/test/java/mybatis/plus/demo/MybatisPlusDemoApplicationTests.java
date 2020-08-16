package mybatis.plus.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mybatis.plus.demo.quickstart.entity.User;
import mybatis.plus.demo.quickstart.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusDemoApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectByCondition() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(
                new QueryWrapper<User>()
                        .lambda()
                        .ge(User::getAge, 20)
        );
        Assert.assertEquals(4, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void lambdaPagination() {
        Page<User> page = new Page<>(1, 2);
        Page<User> result = userMapper.selectPage(page, Wrappers.<User>lambdaQuery().ge(User::getAge, 1).orderByAsc(User::getAge));
        assertThat(result.getTotal()).isLessThan(3);
        assertThat(result.getRecords().size()).isEqualTo(5);
    }

}
