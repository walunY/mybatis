import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import xyz.walun.dao.UserDao;
import xyz.walun.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoTest {
    InputStream in;
    SqlSessionFactoryBuilder builder;
    SqlSessionFactory factory;
    @Before
    public void init() throws IOException {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
    }
    @org.junit.Test
    public void testFirstLevelCache() throws IOException {
        SqlSession sqlSession = factory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User u = userDao.findById(41);
        System.out.println(u);
        System.out.println("***************************");
//        sqlSession.close();
//        sqlSession = factory.openSession();
        sqlSession.clearCache();// 此方法也可以情况缓存
        userDao=sqlSession.getMapper(UserDao.class);
        User u2 = userDao.findById(41);
        System.out.println(u);
        System.out.println(u==u2);
        sqlSession.close();
        in.close();
    }
    @org.junit.Test
    public void testSecondLevelCache() throws IOException {

        SqlSession sqlSession = factory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User u = userDao.findById(41);
        System.out.println(u);

        sqlSession.close();

        System.out.println("***************************");

        SqlSession sqlSession1 = factory.openSession();
        userDao=sqlSession1.getMapper(UserDao.class);
        User u2 = userDao.findById(41);
        System.out.println(u);

        System.out.println(u==u2);


        sqlSession.close();
        sqlSession1.close();
        in.close();
    }



}
