package com.itheima.reggie.filter;


import com.alibaba.fastjson.JSON;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否已经完成登录
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    private static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1.获取本次请求的URI
        String requestURI = request.getRequestURI();
        log.info("拦截到请求：{}", requestURI);

        //2.判断本次请求, 是否需要登录, 才可以访问
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",  // backend/index.html
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login"

        };
        boolean check = check(urls, requestURI);

        //3.如果不需要，则直接放行
        if (check) {
            log.info("本次请求{}不需要处理", requestURI);
            filterChain.doFilter(request, response);
            return;
        }

        //4-1.判断登录状态，如果已登录，则直接放行
      /*  if (request.getSession().getAttribute("employee") != null) {
            log.info("用户已登录，用户id为：{}", request.getSession().getAttribute("employee"));
            filterChain.doFilter(request, response);
            return;employee
        }*/
        if (request.getSession().getAttribute("employee") != null) {

            log.info("用户已登录，用户id为：{}", request.getSession().getAttribute("employee"));

            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);
            log.info("登录用户id为:{}", BaseContext.getCurrentId());

            long id = Thread.currentThread().getId();
            log.info("登录线程id为:{}", id);

            filterChain.doFilter(request, response);
            return;
        }

        //4-2.判断移动端登录状态，如果已登录，则直接放行
        if (request.getSession().getAttribute("user") != null) {
            log.info("用户已登录，用户id为：{}", request.getSession().getAttribute("user"));

            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);

/*            long id = Thread.currentThread().getId();
            log.info("线程id为:{}", id);*/

            filterChain.doFilter(request, response);
            return;
        }

        //5. 如果未登录, 则返回未登录结果
        log.info("用户未登录");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }


    /**
     * 路径匹配，检查本次请求是否放行；
     *
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                return true;
            }
        }

        return false;
    }

}
