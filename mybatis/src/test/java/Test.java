import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import xyz.walun.dao.UserDao;
import xyz.walun.domain.QueryVo;
import xyz.walun.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
		user.setUserName("saveTest and get id");
		user.setUserAddress("四川成都");
		user.setUserBirthday(new Date());
		user.setUserSex("男");
		System.out.println("保存前- -  -- - - "+user);
		userDao.saveUser(user);
		System.out.println("保存后- -  -- - - "+user);

	}

	@org.junit.Test
	public void testUpdateUser(){
		User user = new User();
		user.setUserId(51);
		user.setUserSex("女");
		user.setUserName("更新名称");
		user.setUserAddress("更新地址");

		userDao.updateUser(user);
	}

	@org.junit.Test
	public void testDeleteUser(){
		userDao.deleteUser(51);
	}
	@org.junit.Test
	public void testFindById(){
		User user = userDao.findById(42);
		System.out.println(user);
	}

	@org.junit.Test
	public void testFindByName(){
		List<User> users = userDao.findByName("%王%");
		for(User u : users)
			System.out.println(u);
	}
	@org.junit.Test
	public void testFindTotal(){
		int i = userDao.findTotal();
		System.out.println(i);
	}

	@org.junit.Test
	public void testFindByVo(){
		QueryVo vo = new QueryVo();
		User u = new User();
		u.setUserName("%王%");
		vo.setUser(u);
		List<User> users = userDao.findUserByVo(vo);
		for(User us : users)
			System.out.println(us);
	}

	@org.junit.Test
	public void testfindUserByCondition(){
		User user = new User();
		user.setUserName("小马宝莉");
		user.setUserSex("女");

		List<User> list = userDao.findUserByCondition(user);
		for(User u : list)
			System.out.println(u);
	}

	@org.junit.Test
	public void testfindUserByids(){
		QueryVo vo = new QueryVo();
		List<Integer> list = new ArrayList<Integer>();
		list.add(41);
		list.add(42);
		list.add(43);
		vo.setIds(list);
		List<User> users = userDao.findUserByids(vo);
		for(User us : users)
			System.out.println(us);
	}
}
