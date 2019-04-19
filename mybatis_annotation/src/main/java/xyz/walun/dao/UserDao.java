package xyz.walun.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import xyz.walun.domain.User;

import java.util.List;


/**
 * 针对CRUD一共由4个注解
 * @SELECT @ INSETRT @UPDATE @DELETE
 */
public interface UserDao {


	/**
	 * 查询所有用户
	 * @return
	 */
/*
	@Select("select * from user")
	List<User> findAll();
*/

	@Select("select * from user")
	@Results(id = "userResultMap",
			value ={ @Result(id=true,property = "userId",column = "id"),
			@Result(property = "userName",column = "username"),
			@Result(property = "userSex",column = "sex"),
			@Result(property = "userAddress",column = "address"),
			@Result(property = "userBirthday",column = "birthday"),
			@Result(property = "accountLis",column = "id",many = @Many(select = "xyz.walun.dao.AccountDao.findAccountByUId",fetchType = FetchType.LAZY))
			})
	List<User> findAll();

	@Select("select * from user where id =#{id}")
//	@ResultMap("userResultMap")
	@ResultMap(value = {"userResultMap"})
	User findById(Integer uid);
}
