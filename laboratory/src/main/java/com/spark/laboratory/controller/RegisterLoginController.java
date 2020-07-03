package com.spark.laboratory.controller;

import com.spark.laboratory.pojo.User;
import com.spark.laboratory.pojo.vo.UserVO;
import com.spark.laboratory.service.UserService;
import com.spark.laboratory.utils.FengliJsonResult;
import com.spark.laboratory.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;


/**
 * 用户注册登录接口
 * @author lixizheng
 * @date 2020/07/02
 */
@RestController()
public class RegisterLoginController extends BasicController{

	private final UserService userService;

	@Autowired
	public RegisterLoginController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 注册
	 * @param user 用户对象
	 * @return json数据
	 */
	@PostMapping("/regist")
	public FengliJsonResult regist(User user) 	{

		// 1. 判断用户名和密码必须不为空
		if (StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getUserPassword())) {
			return FengliJsonResult.errorMsg("用户名和密码不能为空");
		}

		// 2. 判断用户名是否存在
		boolean usernameIsExist = userService.queryUsernameIsExist(user.getUserName());

		// 3. 保存用户，注册信息
		if (!usernameIsExist){
			try {
				user.setUserPassword(MD5Utils.getMD5Str(user.getUserPassword()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			user.setCreateTime(new Date());
			user.setIsDelete("0");
			user.setUserNickname(user.getUserName());
			userService.saveUser(user);
		}else{
			return FengliJsonResult.errorMsg("用户名已经存在，请换一个再试");
		}

		UserVO userVO = new UserVO();
		userVO.setUserName(user.getUserName());
		userVO.setCreateTime(user.getCreateTime());
		userVO.setUserMail(user.getUserMail());
		userVO.setUserPhone(user.getUserPhone());

		return FengliJsonResult.ok(userVO);
	}

	/**
	 * 登录
	 * @param user 用户对象
	 * @param response http 响应对象
	 * @param session 服务器端会话
	 * @return json数据
	 * @throws Exception  MD5工具解析异常
	 */
	@PostMapping("/login")
	public FengliJsonResult login(User user, HttpServletResponse response, HttpSession session) throws Exception {

		String username = user.getUserName();
		String password = user.getUserPassword();

		// 返回前端对象
		UserVO userVO = new UserVO();

		// 1. 判断用户名和密码必须不为空
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			userVO.setErrorInfo("用户名或密码不能为空...");
			return FengliJsonResult.ok(userVO);
		}

		// 2. 判断用户是否存在
		User userResult = userService.queryUserForLogin(username,
				MD5Utils.getMD5Str(user.getUserPassword()));

		// 3. 返回
		if (userResult != null) {
			userResult.setUserPassword("");
			Cookie cookie = new Cookie("isLogin", "1");
			cookie.setMaxAge(1000 * 60 * 30);
			response.addCookie(cookie);

			session.setAttribute("user", SESSION_KEY);

			return FengliJsonResult.ok(userVO);
		} else {
			userVO.setErrorInfo("用户名或密码不正确, 请重试...");
			return FengliJsonResult.ok(userVO);
		}

	}

	/**
	 * 注销
	 * @param request http 请求对象
	 * @return json数据
	 */
	@PostMapping("/logout")
	public FengliJsonResult logout(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("isLogin".equals(cookie.getName())){
					cookie.setMaxAge(0);
				}
			}
		}

		HttpSession session = request.getSession();
		session.removeAttribute("user");

		return FengliJsonResult.ok();
	}

}
