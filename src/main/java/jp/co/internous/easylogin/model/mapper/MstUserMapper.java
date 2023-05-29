package jp.co.internous.easylogin.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.easylogin.model.domain.MstUser;

@Mapper //データベースにアクセスするDAO
public interface MstUserMapper {
	
	@Select("SELECT * FROM mst_user WHERE user_name = #{userName} AND password = #{password}")
	MstUser findByUserNameAndPassword(String userName, String password);
	//ログイン時に受け取った変数を代入してSQL文に入れる
	//domainを経由してDBにアクセス
}
