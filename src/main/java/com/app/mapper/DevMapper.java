package com.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
			+ ") VALUES ("
			+ "#{storeNum},#{review}) ")
	public int InsertReview(Map map);
	
	@Insert(  "INSERT INTO signup ("
			+ "UserNum,"
			+ "UserId,"
			+ "UserPw,"
			+ "UserName) VALUES "
			+ "(#{UserId},#{UserPw},#{UserName}) ")
	public int insertOne();
		
	@Select(" SELECT A.StoreNum , B.Review "
			+ "	FROM storeList as A "
			+ "    	INNER JOIN Review as B "
			+ "    	ON A.StoreNum = B.StoreNum "
			+ "    	WHERE A.StoreNum  = #{StoreNum}") 
	public List<Map> listReview(@Param("StoreNum") int StoreNum);
	
	 @Select("SELECT * "
			+ "FROM StoreList "
			+ "WHERE StoreNum = #{StoreNum}")
	public Map findOne(@Param("StoreNum") int StoreNum); 
	
	
	 @Insert("INSERT INTO user ("
	 		+ "userNm, "
	 		+ "userId, "
	 		+ "userPwd, "
	 		+ "userEmail) VALUES "
	 		+ "(#{userNm}, #{userId}, #{userPwd}, #{userEmail})")
	 int signup(Map<String, Object> user); // 혹은 int signup(User user);
	
	
	
	
	
	
}
