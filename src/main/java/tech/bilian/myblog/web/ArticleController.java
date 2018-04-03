package tech.bilian.myblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.bilian.myblog.dto.*;
import tech.bilian.myblog.pojo.Article;
import tech.bilian.myblog.pojo.ArticleType;
import tech.bilian.myblog.service.ArticleService;
import tech.bilian.myblog.service.ArticleTypeService;
import tech.bilian.myblog.service.UserService;
import tech.bilian.myblog.utils.HttpServletRequestUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "article")
public class ArticleController {
    @Resource
    ArticleService articleService;
    @Resource
    UserService userService;
    @Resource
    ArticleTypeService articleTypeService;

    @RequestMapping(value = "articleindexinfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> articleIndexInfo(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<>();
        int articleCount = articleService.queryArticleCount(new Article());
        if(articleCount < 0){
            modelMap.put("success", false);
            modelMap.put("errMsg","文章数量查找失败！！！");
            return modelMap;
        }
//        String aaa = request.getParameter("pageCount");
//        if (aaa == null){
//            aaa = "lfjalkfjlfzhasldfjldksf";
//        }
//
//        modelMap.put("pageCount", aaa);

        int pageCount = HttpServletRequestUtil.getInt(request,"pageCount");
        int parentTypeId = HttpServletRequestUtil.getInt(request, "parentTypeId");
        int typeId = HttpServletRequestUtil.getInt(request, "typeId");
        if(pageCount < 1){
            pageCount = 1;
        }

        //查找用户基本信息
        UserExecution userExecution = userService.selectUserDetailsById(1l);
        if(userExecution.getState()<1){
            modelMap.put("success", false);
            modelMap.put("errMsg", userExecution.getStateInfo());
            return modelMap;
        }

        //查找一级目录
        ArticleTypeExecution articleParentTypeExecution = articleTypeService.queryArticleType(null);
        if(articleParentTypeExecution.getState()<1){
            modelMap.put("success", false);
            modelMap.put("errMsg", articleParentTypeExecution.getStateInfo());
            return modelMap;
        }

        //查找二级目录
        ArticleType articleType = new ArticleType();
        articleType.setParent(new ArticleType());
        ArticleTypeExecution articleTypeExecution = articleTypeService.queryArticleType(articleType);
        if(articleTypeExecution.getState()<1){
            modelMap.put("success", false);
            modelMap.put("errMsg", articleTypeExecution.getStateInfo());
            return modelMap;
        }

        //根据一级目录查询(需要两个表 情况特殊)
        if(typeId <= 0 && parentTypeId >0){
            int rowIndex = 10 * (pageCount - 1);
            Article article1 = new Article();
            ArticleType articleType1 = new ArticleType();
            ArticleType parentType = new ArticleType();
            parentType.setArticleTypeId(parentTypeId);
            articleType1.setParent(parentType);
            article1.setArticleType(articleType1);
            ParentTypeExecution parentTypeExecution = articleService.getArticleIndexInfoByParentType(article1, rowIndex, 10);
            if(parentTypeExecution.getStatus() <= 0){
                modelMap.put("success", false);
                modelMap.put("errMsg", parentTypeExecution.getStatusInfo());
            }
            modelMap.put("success", true);
            modelMap.put("secondType", articleTypeExecution.getArticleTypeList());
            modelMap.put("firstType", articleParentTypeExecution.getArticleTypeList());
            modelMap.put("user", userExecution.getUser());
            modelMap.put("articleCount", parentTypeExecution.getCount());
            modelMap.put("articleList", parentTypeExecution.getArticleList());
            return modelMap;
        }

        //查询符合条件文章
        Article article2 = new Article();
        if(typeId > 0){
            ArticleType articleType2 = new ArticleType();
            articleType2.setArticleTypeId(typeId);
            article2.setArticleType(articleType2);
        }
        System.out.println(pageCount);
        int rowIndex = 10 * (pageCount - 1);
        Execution<Article> articleList = articleService.queryArticleList(article2, rowIndex, 10);
        if(articleList.getState() != 1){
            modelMap.put("success", false);
            modelMap.put("errMsg", articleList.getStateInfo());
            return modelMap;
        }



        modelMap.put("secondType", articleTypeExecution.getArticleTypeList());
        modelMap.put("firstType", articleParentTypeExecution.getArticleTypeList());
        modelMap.put("articleCount", articleCount);
        modelMap.put("success", true);
        modelMap.put("articleList", articleList.getModels());
        modelMap.put("user", userExecution.getUser());

        System.out.println("dlfkjsl;fjsflaskjfasldfjdasklfd");
        return modelMap;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(){
        return "article/index";
    }


    @RequestMapping(value = "articledetails", method = RequestMethod.GET)
    public String articleDetails(){
        return "article/articledetails";
    }



    @RequestMapping(value = "articledetailsinfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> articleDetailsInfo(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<>();

        Long articleId = HttpServletRequestUtil.getLong(request, "articleId");
        if(articleId <= 0){
            modelMap.put("success", false);
            modelMap.put("errMsg", "文章选择错误！！！");
            return modelMap;
        }
//        Article article = new Article();
//        article.setArticleId(articleId);
        Execution<Article> articleExecution = articleService.getArticleById(articleId);
        if(articleExecution.getState()<0){
            modelMap.put("success", false);
            modelMap.put("errMsg", articleExecution.getStateInfo());
            return modelMap;
        }
//        long articleSize = articleService.queryArticleCount(null);
//        if(articleSize < 0){
//            modelMap.put("success", false);
//            modelMap.put("errMsg", "文章总数查询失败！！！");
//            return modelMap;
//        }

        modelMap.put("success", true);
        modelMap.put("article", articleExecution.getModel());
        //modelMap.put("articleSize", articleSize);
        return modelMap;
    }

    @RequestMapping(value = "/img", method = RequestMethod.GET)
    public String img(){
        return "/article/img";
    }
}
