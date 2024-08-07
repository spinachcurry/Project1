package com.pjt.project01.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DevMapper {

	//김유저 불러오는 데이터라 테스트용
//	@Select("SELECT * FROM signup")
//	public List<Map> signup();
	
	@Select("SELECT * FROM StoreList")
	public List<Map> storeList();
	
	@Insert(  "INSERT INTO review ("
			+ "storeNum,"
			+ "review"
			+ ")VALUES ("
			+ "#{storeNum},#{review}) ")
	public int review(Map map);
	
	@Insert(  "INSERT INTO signup ("
			+ "UserNum,"
			+ "UserId,"
			+ "UserPw,"
			+ "UserName)VALUES "
			+ "(#{UserId},#{UserPw},#{UserName}) ")
	public int insertOne();
		
	@Select("SELECT A.* , B.Review "
			+ "FROM StoreList as A "
			+ "INNER JOIN Review as B "
			+ "ON A.storeNum = B.storeNum")
	public List<Map> list1();
	
	
	@Insert("INSERT INTO Signup("
			+ "UserNum,"
			+ "UserId,"
			+ "UserPw,"
			+ "UserName)VALUES"
			+ "(#{UserNum}, #{UserId}, #{UserPw} ,#{UserName})")
	public List<Map> signup();
	
	
	
	
	
	
}
