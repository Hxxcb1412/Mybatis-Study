import com.shido.dao.UserMapper;
import com.shido.pojo.User;
import com.shido.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class UserMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 底层主要应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User userById = mapper.getUserById(1);
//        System.out.println(userById);
//        mapper.addUser(new User(5, "Animal", "116622"));
//        mapper.updateUser(new User(5, "SSShi", "123111"));
        mapper.deleteUser(5);
        sqlSession.close();
    }
}
