package com.shido.dao;

import com.shido.pojo.User;
import com.shido.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("%F%");
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

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

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 2);
        System.out.println(mapper.getUserById2(map));

        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(4, "攻陷之神", "112233"));
        if (res > 0){
            System.out.println("插入成功");
            sqlSession.commit();
        }else {
            System.out.println("插入失败");
            sqlSession.rollback();
        }

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new User(4, "千恋万花", "111333"));
        if (res > 0){
            System.out.println("修改成功");
            sqlSession.commit();
        }else {
            System.out.println("修改失败");
            sqlSession.rollback();
        }

        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(4);
        if (res > 0){
            System.out.println("删除成功");
            sqlSession.commit();
        }else {
            System.out.println("删除失败");
            sqlSession.rollback();
        }

        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("userid", 5);
        map.put("passWord", "222333");
        mapper.addUser2(map);

        sqlSession.close();
    }
}

