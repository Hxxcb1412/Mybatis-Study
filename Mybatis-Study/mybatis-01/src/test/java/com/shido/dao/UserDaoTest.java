package com.shido.dao;

import com.shido.pojo.User;
import com.shido.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        // 第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            // 方式一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();

            // 方式二：
//        List<User> userList = sqlSession.selectList("com.shido.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 关闭sqlSession
            sqlSession.close();
        }

    }
}
