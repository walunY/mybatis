package xyz.walun.dao;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import xyz.walun.domain.Account;
import xyz.walun.domain.User;

import java.util.List;

public interface AccountDao {
	@Select("select * from account")
	@Results(id = "accountMap",value = {
			@Result(id = true,column = "id",property = "id"),
			@Result(column = "uid",property = "uid"),
			@Result(column = "money",property = "money"),
			@Result(property = "user",column = "uid",one=@One(select = "xyz.walun.dao.UserDao.findById",fetchType = FetchType.EAGER))
			/*       要包装的属性      传入的参数     对一的关系(对多用many)    查询方法的全限定名          加载方式*/
	})
	List<Account> findAccount();

	@Select("select * from account where uid = #{uid}")
	List<Account> findAccountByUId(Integer uid);
}
