package jp.co.internous.easylogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.easylogin.model.domain.MstUser;
import jp.co.internous.easylogin.model.mapper.MstUserMapper;

@Controller
@RequestMapping("/easylogin")
public class LoginController {
	
	@Autowired //このクラスを自動でインスタンス化
	private MstUserMapper userMapper;
	
	@GetMapping("/") //ログイン画面の表示
	public String index() {
		return "index";
	}
	
	@GetMapping("login") //ログイン後の画面の表示
	public String login(String userName, String password, Model model) {
		
		MstUser user = userMapper.findByUserNameAndPassword(userName, password);
		//Mapperを使ってデータベースにアクセス(MstUserMapperを参照)
		
		if (user == null) {
			model.addAttribute("message", "ゲストさん、ようこそ！");
		} else {
			model.addAttribute("message", user.getFullName() + "さん、ようこそ！");
		}
		
		return "login";
	}

}