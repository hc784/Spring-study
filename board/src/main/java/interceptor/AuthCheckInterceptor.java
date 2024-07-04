package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthCheckInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session!= null)
		{
			Object authInfo = session.getAttribute("authInfo");
			if(authInfo!=null) {
				response.sendRedirect(request.getContextPath()+"/main");
				return false;
			}
		}
		
		return true;
	}
}
