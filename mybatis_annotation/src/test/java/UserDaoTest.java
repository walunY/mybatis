import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import xyz.walun.dao.UserDao;
import xyz.walun.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoTest {
	private InputStream in;
	private SqlSessionFactoryBuilder builder;
	private SqlSessionFactory build;
	private SqlSession sqlSession;
	@Before
	public void init() throws IOException {
		in = Resources.getResourceAsStream("SqlMapConfig.xml");
		builder  = new SqlSessionFactoryBuilder();
		build = builder.build(in);
		sqlSession = build.openSession();
	}

	@After
	public void destory() throws IOException {
		sqlSession.close();
		in.close();
	}

	@Test
	public  void testSelecAnno(){
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		List<User> all = userDao.findAll();
		for (User u : all) {
			System.out.println("******************************");
			System.out.println(u.getAccountLis());
			System.out.println(u);
		}
	}

	@Test
	public  void testFindById(){
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		User u = userDao.findById(41);
		System.out.println(u);
	}
}
