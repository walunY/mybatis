import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import xyz.walun.dao.AccountDao;
import xyz.walun.dao.UserDao;
import xyz.walun.domain.Account;
import xyz.walun.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountDaoTest {
	private InputStream in;
	private SqlSessionFactoryBuilder builder;
	private SqlSessionFactory build;
	private SqlSession sqlSession;
	private AccountDao accountDao;
	@Before
	public void init() throws IOException {
		in = Resources.getResourceAsStream("SqlMapConfig.xml");
		builder  = new SqlSessionFactoryBuilder();
		build = builder.build(in);
		sqlSession = build.openSession();
		accountDao = sqlSession.getMapper(AccountDao.class);
	}

	@After
	public void destory() throws IOException {
		sqlSession.close();
		in.close();
	}

	@Test
	public  void testSelecAnno(){
		List<Account> all = accountDao.findAccount();
		for (Account a : all) {
			System.out.println("********************");
			System.out.println(a);
			System.out.println(a.getUser());
		}
	}
	@Test
	public  void testSelectByUId(){
		List<Account> accounts = accountDao.findAccountByUId(45);
		for (Account account:accounts)
			System.out.println(account);
		}

}
