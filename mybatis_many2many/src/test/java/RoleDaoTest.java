import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.walun.dao.RoleDao;
import xyz.walun.dao.UserDao;
import xyz.walun.domain.Role;
import xyz.walun.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RoleDaoTest {
    @org.junit.Test
    public void testFindAll() throws IOException {
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        RoleDao Dao = sqlSession.getMapper(RoleDao.class);
        List<Role> list = Dao.findAll();
        for(Role r : list) {
            System.out.println("========================");
            System.out.println(r.getUsers());
            System.out.println(r);
        }
        sqlSession.close();
        in.close();
    }





}
