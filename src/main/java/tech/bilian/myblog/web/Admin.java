package tech.bilian.myblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.bilian.myblog.service.ArticleService;
import tech.bilian.myblog.service.ArticleTypeService;
import tech.bilian.myblog.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("admin")
public class Admin {
    @Resource
    ArticleService articleService;

    @Resource
    ArticleTypeService articleTypeService;

    @Resource
    UserService userService;


    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String logIn(){
        return "admin/login";
    }


    /**
     * 文章添加页面
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "articleadd", method = RequestMethod.GET)
    public String articleAdd(HttpServletRequest request, HttpServletResponse response){
        if(request.getSession().getAttribute("userId") == null){
            try {
                response.sendRedirect("login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "admin/articleadd";
    }

    /**
     * 后台首页
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "adminindex", method = RequestMethod.GET)
    public String adminIndex(HttpServletRequest request, HttpServletResponse response){
        if(request.getSession().getAttribute("userId") == null){
            try {
                response.sendRedirect("login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "admin/adminindex";
    }
}
