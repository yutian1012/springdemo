package org.sjq.test.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sjq.test.model.Spitter;

@Mapper
public interface SpitterRepository {
	
	@Select("SELECT * FROM spitter WHERE username = #{username}")
    Spitter findByUsername(@Param("username") String username);

	//问题：能不能传递对象然后保存？
    @Insert("INSERT INTO spitter(username,password,fullName,email,updateByEmail,status ) "
    		+ "VALUES(#{username}, #{password},#{fullName},#{email}, #{updateByEmail},#{status})")
    int save(@Param("username") String username, @Param("password") String password,@Param("fullName")String fullName,
    		@Param("email") String email, @Param("updateByEmail") boolean updateByEmail,@Param("status")String status);
}
