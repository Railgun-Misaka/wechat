package interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import util.XMLtoMAP;

@Component
public class WeixinInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler) throws Exception {
         
        String method = request.getMethod();
        if(method.equals("GET"))
        	return true;
		
        Map<String, String> map = XMLtoMAP.transform(request.getInputStream());
        if(map.isEmpty())
        	return false;
        request.setAttribute("map", map);
        return true;
         
    } 
    
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,    
            ModelAndView modelAndView) throws Exception {  
        System.out.println("postHandle(), 在访问Controller之后，访问视图之前被调用,这里可以注入一个时间到modelAndView中，用于后续视图显示");
    }  
    
	@Override
    public void afterCompletion(HttpServletRequest request,    
            HttpServletResponse response, Object handler, Exception ex) throws Exception {    
        System.out.println("afterCompletion(), 在访问视图之后被调用");  
    }  
}
