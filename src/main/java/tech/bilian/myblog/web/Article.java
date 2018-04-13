package tech.bilian.myblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.bilian.myblog.service.ArticleService;
import tech.bilian.myblog.service.ArticleTypeService;
import tech.bilian.myblog.service.UserService;

import javax.annotation.Resource;

@Controller
@RequestMapping("article")
public class Article {
    @Resource
    ArticleService articleService;
    @Resource
    UserService userService;
    @Resource
    ArticleTypeService articleTypeService;


    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(){
        return "article/index";
    }


    /**
     * 文章具体内容页
     *
     * @return
     */
    @RequestMapping(value = "articledetails", method = RequestMethod.GET)
    public String articleDetails(){
        return "article/articledetails";
    }

    /**
     * 图片页
     *
     * @return
     */
    @RequestMapping(value = "/img", method = RequestMethod.GET)
    public String img(){
        return "/article/img";
    }
}
