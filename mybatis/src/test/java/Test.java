import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.walun.dao.UserDao;
import xyz.walun.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
	@org.junit.Test
	public void testFindAll() throws IOException {
		// 加载配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 获得sqlsession
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(inputStream);
		SqlSession sqlSession = factory.openSession();
		// 获得代理对象
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		// 执行方法
		List<User> list = userDao.findAll();
		for(User u : list)
			System.out.println(u);
		// 释放资源
		sqlSession.close();
		inputStream.close();
	}
}
