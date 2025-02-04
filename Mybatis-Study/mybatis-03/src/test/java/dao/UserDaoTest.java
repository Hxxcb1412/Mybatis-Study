package dao;

import com.shido.dao.UserMapper;
import com.shido.pojo.User;
import com.shido.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    // select * from mybatis.user where id = #{id}
    // 类型处理器
    // select id, name, pwd as password from mybatis.user where id = #{id}
}

