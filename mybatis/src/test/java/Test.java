import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import xyz.walun.dao.UserDao;
import xyz.walun.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Test {
	private InputStream in;
	private SqlSession sqlSession;
	private UserDao userDao;
	@Before
	public void init() throws IOException {
		// 加载配置对象
		in = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 创建工厂类
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(in);

		// 获得sqlSession对象
		sqlSession= factory.openSession();

		// 获得接口对象(反射的方式)
		userDao= sqlSession.getMapper(UserDao.class);
	}

	@After
	public void destroy() throws IOException {
		// 需要提交事务 CRUD才能生效
		sqlSession.commit();
		in.close();
		sqlSession.close();
	}

	@org.junit.Test
	public void testFindAll(){
		// 执行方法
		List<User> list = userDao.findAll();
		for(User u : list)
			System.out.println(u);
		// 释放资源

	}

	@org.junit.Test
	public void testSave(){
		User user = new User();
		user.setUsername("saveTest");
		user.setAddress("四川成都");
		user.setBirthday(new Date());
		user.setSex("男");
		userDao.saveUser(user);


	}
}
