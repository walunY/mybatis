import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.walun.dao.AccountDao;
import xyz.walun.dao.UserDao;
import xyz.walun.domain.Account;
import xyz.walun.domain.User;
import xyz.walun.domain.UserAccount;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    @org.junit.Test
    public void testFindAll() throws IOException {
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.findAll();
        for(User u : list)
            System.out.println(u);
        sqlSession.close();
        in.close();
    }
    @org.junit.Test
    public void testFindByID() throws IOException {
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User u = userDao.findById(42);
        System.out.println(u);
        sqlSession.close();
        in.close();
    }

    @org.junit.Test
    public void testFindAllAT() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        List<Account> list = dao.findAll();
        for(Account a: list)
        System.out.println(a);
        sqlSession.close();
        in.close();
    }

    @org.junit.Test
    public void testFindAllAccountAT() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        List<UserAccount> list = dao.findAllAccount();
        for(UserAccount a: list)
            System.out.println(a);
        sqlSession.close();
        in.close();
    }

}
