package com.spark.laboratory.controller.interceptor;

import com.spark.laboratory.utils.FengliJsonResult;
import com.spark.laboratory.utils.JsonUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 *  自定义拦截器
 *
 * @author Administrator
 */
public class MiniInterceptor implements HandlerInterceptor {

	public static final String USER_REDIS_SESSION = "user-redis-session";
	
	/**
	 * 拦截请求，在controller调用之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg2) throws Exception {
		String userId = request.getHeader("headerUserId");
		String userToken = request.getHeader("headerUserToken");

//		if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(userToken)) {
//			String uniqueToken = redis.get(USER_REDIS_SESSION + ":" + userId);
//			if (StringUtils.isEmpty(uniqueToken) && StringUtils.isBlank(uniqueToken)) {
//				System.out.println("请登录...");
//				returnErrorResponse(response, new FengliJsonResult().errorTokenMsg("请登录..."));
//				return false;
//			} else {
//				if (!uniqueToken.equals(userToken)) {
//					System.out.println("账号被挤出...");
//					returnErrorResponse(response, new FengliJsonResult().errorTokenMsg("账号被挤出..."));
//					return false;
//				}
//			}
//		} else {
//			System.out.println("请登录...");
//			returnErrorResponse(response, new FengliJsonResult().errorTokenMsg("请登录..."));
//			return false;
//		}
		
		
		/**
		 * 返回 false：请求被拦截，返回
		 * 返回 true ：请求OK，可以继续执行，放行
		 */
		return true;
	}
	
	public void returnErrorResponse(HttpServletResponse response, FengliJsonResult result)
			throws IOException {
		OutputStream out=null;
		try{
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("text/json");
		    out = response.getOutputStream();
		    out.write(Objects.requireNonNull(JsonUtils.objectToJson(result)).getBytes(StandardCharsets.UTF_8));
		    out.flush();

		} finally{
		    if(out!=null){
		        out.close();
		    }
		}
	}
	
	/**
	 * 请求controller之后，渲染视图之前
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}
	
	/**
	 * 请求controller之后，视图渲染之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

}
