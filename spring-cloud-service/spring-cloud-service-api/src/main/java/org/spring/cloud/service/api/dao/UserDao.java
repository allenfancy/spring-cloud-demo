package org.spring.cloud.service.api.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.spring.cloud.service.api.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Select("select id,username,password,nickname,sex,email,tel,countryID from user where id =#{id}")
   /* @Results({
            @Result(id = true,column = "id",property = "id",javaType = Integer.class,jdbcType = JdbcType.INTEGER)

    })*/
    User findById(@Param("id") Integer id);

    @Select("select id,username,password,nickname,sex,email,tel,countryID from user where nickname =#{nickname}")
    User findByName(@Param("nickname") String nickname);

    @Insert("INSERT INTO user (username,password,nickname,sex,email,tel,countryID) "
            + "VALUES (#{username},#{password},#{nickname},#{sex},#{email},#{tel},#{countryID})")
    @Options(useGeneratedKeys = true)
    void save(User user);

    @Update(value = "update user set nicknane=nickname where id = #id")
    int updateNickName(@Param("nickname") String nickname, @Param("id") Integer id);

    @Delete(value = "delete from user where id =#id")
    int deleteUser(@Param("id") Integer id);
}
