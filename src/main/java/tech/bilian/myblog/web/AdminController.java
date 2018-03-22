package tech.bilian.myblog.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.code.kaptcha.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import tech.bilian.myblog.dao.UserDao;
import tech.bilian.myblog.dto.ArticleExecution;
import tech.bilian.myblog.dto.ArticleTypeExecution;
import tech.bilian.myblog.dto.UserExecution;
import tech.bilian.myblog.pojo.Article;
import tech.bilian.myblog.pojo.ArticleType;
import tech.bilian.myblog.pojo.User;
import tech.bilian.myblog.service.ArticleService;
import tech.bilian.myblog.service.ArticleTypeService;
import tech.bilian.myblog.service.UserService;
import tech.bilian.myblog.utils.CodeUtil;
import tech.bilian.myblog.utils.HttpServletRequestUtil;
import tech.bilian.myblog.utils.Image;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "admin")
public class AdminController {

    @Resource
    ArticleService articleService;

    @Resource
    ArticleTypeService articleTypeService;

    @Resource
    UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String logIn(){
        return "admin/login";
    }

    @RequestMapping(value = "articleadd", method = RequestMethod.GET)
    public String articleAdd(HttpServletRequest request, HttpServletResponse response){
        if(request.getSession().getAttribute("userId") == null){
            try {
                response.sendRedirect("/admin/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "admin/articleadd";
    }

    @RequestMapping(value = "articleinsert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> articleInsert(HttpServletRequest request) {
        System.out.println("zhangjiahao");

        Map<String, Object> modelMap = new HashMap<>();
        if(request.getSession().getAttribute("userId") == null){
            modelMap.put("success", false);
            modelMap.put("errMsg", "请先登录");
            return modelMap;
        }
        String verifyCodeActual = request.getParameter("verifyCodeActual");
        if(!CodeUtil.ckechVerifyCode(request, verifyCodeActual)){
            modelMap.put("success", false);
            modelMap.put("errMsg", "验证码输入错误！！！");
            return modelMap;
        }
        String articleString = HttpServletRequestUtil.getString(request, "article");
        Article article = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            article = mapper.readValue(articleString, Article.class);
            }catch (Exception e){
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }
        CommonsMultipartFile articleImage = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            articleImage = (CommonsMultipartFile) multipartHttpServletRequest.getFile("articleImg");
        }else{
            modelMap.put("success", false);
            modelMap.put("errMsg", "上传图片不能为空");
            return modelMap;
        }
        if(article == null || articleImage == null){
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入完整信息");
            return modelMap;
        }
        try{
            Image image = new Image(articleImage.getOriginalFilename(), articleImage.getInputStream());
            Long userId = Long.valueOf(request.getSession().getAttribute("userId").toString());

            ArticleExecution articleExecution = articleService.insertArticle(article, image, userId);
            if(articleExecution.getState() == 1){
                modelMap.put("success", true);
                modelMap.put("successMsg", "添加成功");
                return modelMap;
            }
            else {
                modelMap.put("success", false);
                modelMap.put("errMsg", "添加失败");
                return modelMap;
            }
        }catch (IOException e){
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }


       // String savePath="/home/haru/imagestest/save";
//        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//        if(isMultipart==true){
//            InputStream in = null;
//            FileOutputStream out = null;
//
//            ObjectMapper mapper = new ObjectMapper();
//            Article article = null;
//            Image image = null;
//            File imageFile = null;
//            String articleString = null;
//            String verifyCodeActual = null;
//
//
//
//            try{
//                FileItemFactory factory = new DiskFileItemFactory();
//                ServletFileUpload upload = new ServletFileUpload(factory);
//
//                String encoding = request.getCharacterEncoding();
//
//                System.out.println(encoding);
//
//
//                upload.setHeaderEncoding(encoding);
//
//                List<FileItem> items = upload.parseRequest(request);//得到所有的文件
//                Iterator<FileItem> itr = items.iterator();
//                while(itr.hasNext()) {//依次处理每个文件
//
//                    FileItem item = (FileItem) itr.next();
//                    if (item.isFormField()) {
//                        // 普通表单域
//                        String name = item.getFieldName();
//                        String value = item.getString(encoding);
//
//                        if (name.equals("article"))
//                            articleString = value;
//                        else
//                            verifyCodeActual = value;
//                        //获得article对象
//
//
//                        System.out.println("name:" + name + "value" + value);
//                    } else {
//                        String fileName = item.getName();
//                        if (fileName == null || fileName.trim().equals("")) {
//                            continue;
//                        }
//                        fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
//                        in = item.getInputStream();
//
//
//                        out = new FileOutputStream(savePath + "/" + fileName);
//                        byte[] buffer = new byte[1024 * 1024];
//                        int len = 0;
//                        while ((len = in.read(buffer)) != -1) {
//                            out.write(buffer, 0, len);
//                        }
//                        imageFile = new File(savePath + "/" + fileName);
//                        // InputStream is = new FileInputStream(imageFile);
//                        // image = new Image(fileName, is);
//                        // 关闭流
//                        if (out != null) {
//                            out.close();
//                        }
//                        if (in != null) {
//                            in.close();
//                        }
//                    }
//                }
//                String verifyCodeExpected = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
//                //判断验证码
//                if(!CodeUtil.ckechVerifyCode(request, verifyCodeActual)){
//                    modelMap.put("success", false);
//                    modelMap.put("errMsg", "验证码输入错误！！！");
//                    return modelMap;
//                }
//
//                try {
//                    article = mapper.readValue(articleString, Article.class);
//                }catch (Exception e){
//                    modelMap.put("success", false);
//                    modelMap.put("errMsg", e.getMessage());
//                    return modelMap;
//                }
//
//
////                    String fileName=item.getName();//获得文件名，包括路径
////                    if(fileName!=null){
////                        File fullFile=new File(item.getName());
////                        File savedFile=new File(uploadPath,fullFile.getName());
////                        item.write(savedFile);
////                    }
//                // }
//                System.out.print("upload succeed");
//                try {
//                    Long userId = Long.valueOf(request.getSession().getAttribute("userId").toString());
//                    System.out.println("userId: " + userId);
//                    ArticleExecution articleExecution = articleService.insertArticle(article, imageFile, userId);
//                    modelMap.put("success", true);
//                    modelMap.put("successMsg", articleExecution.getStateInfo());
//                    return modelMap;
//                }catch (Exception e){
//                    modelMap.put("success", false);
//                    modelMap.put("errMsg", e.getMessage());
//                    return modelMap;
//                }
//
//
//            }
//            catch(Exception e){
//                modelMap.put("success", false);
//                modelMap.put("errMsg", e.getMessage());
//                return modelMap;
//            }
//
//        }else {
//            modelMap.put("success", false);
//            modelMap.put("errMsg","文章上传错误！！！！");
//            return modelMap;
//        }

//        byte[] bytes = new byte[1024 * 1024];
//        InputStream is;
//        try {
//            is = request.getInputStream();
//            int nRead = 1;
//            int nTotalRead = 0;
//            while (nRead > 0) {
//                nRead = is.read(bytes, nTotalRead, bytes.length - nTotalRead);
//                if (nRead > 0)
//                    nTotalRead = nTotalRead + nRead;
//            }
//            String str = new String(bytes, 0, nTotalRead, "utf-8");
//            System.out.println("Str:" + str);
//            is.close();
//            is = null;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    @RequestMapping(value = "getinsertpageinitinfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getInsertPageInitInfo(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<>();
        ArticleType articleType = new ArticleType();
        ArticleType parent = new ArticleType();
        articleType.setParent(parent);
        ArticleTypeExecution articleTypeExecution = articleTypeService.queryArticleType(articleType);
        if(articleTypeExecution.getState() == 0){
            modelMap.put("success", false);
            modelMap.put("errMsg", articleTypeExecution.getStateInfo());
            return modelMap;
        }
        if(articleTypeExecution.getState() == -1){
            modelMap.put("success", false);
            modelMap.put("errMsg", articleTypeExecution.getStateInfo());
            return modelMap;
        }
        modelMap.put("success", true);
        modelMap.put("articleTypeList", articleTypeExecution.getArticleTypeList());
        return modelMap;
    }


    @RequestMapping(value = "/checkuser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkUser(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> modelMap = new HashMap<>();
        String userName = HttpServletRequestUtil.getString(request, "userName");
        String password = HttpServletRequestUtil.getString(request, "password");
        String verifyCodeActual = HttpServletRequestUtil.getString(request, "kaptcha");
        if(userName==null || password==null || verifyCodeActual==null){
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入完整数据！！！");
            return modelMap;
        }
        if(!CodeUtil.ckechVerifyCode(request, verifyCodeActual)){
            modelMap.put("success", false);
            modelMap.put("errMsg", "验证码输入错误！！！");
            return modelMap;
        }
        User user = new User();
        user.setUserName(userName);
        UserExecution userExecution = userService.queryUser(user);
        if(password.equals(userExecution.getUser().getUserPassword())){
            request.getSession().setAttribute("user", userName);
            request.getSession().setAttribute("userId", userExecution.getUser().getUserId());
            System.out.println("success login");
            modelMap.put("success", true);

            return modelMap;
        }else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "登录失败");
            return modelMap;
        }

    }



    @RequestMapping(value = "adminindex", method = RequestMethod.GET)
    public String adminIndex(HttpServletRequest request, HttpServletResponse response){
        if(request.getSession().getAttribute("userId") == null){
            try {
                response.sendRedirect("/admin/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "admin/adminindex";
    }


    @RequestMapping(value = "admininitinfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> adminInitInfo(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<>();
        if(request.getSession().getAttribute("userId") == null){
            modelMap.put("success", false);
            modelMap.put("errMsg", "用户未登录");
            return modelMap;
        }

        int articlePage = HttpServletRequestUtil.getInt(request, "articlePage");
        int articleTypeId = HttpServletRequestUtil.getInt(request, "articleType");

        if(articlePage < 1){
            articlePage = 1;
        }
        Article article = new Article();

        long userId = Long.valueOf(request.getSession().getAttribute("userId").toString());
        System.out.println("userId " + userId);
        User user = new User();
        user.setUserId(userId);
        article.setArticleOwner(user);
        if(articleTypeId > 0){
            ArticleType articleType = new ArticleType();
            articleType.setArticleTypeId(articleTypeId);
            article.setArticleType(articleType);
        }
        int articleCount = articleService.getArticleInitInfoCount(article);
        System.out.println("articleCount:" + articleCount);

        int rowIndex = (articlePage - 1) * 10;
        if(rowIndex > articleCount){
            modelMap.put("success", false);
            modelMap.put("errMsg", "无效页面");
            return  modelMap;
        }
        ArticleExecution  execution = articleService.getArticleInitInfo(article, rowIndex, 10 );
        List<Article> articles = execution.getArticleList();
        ArticleType articleType = new ArticleType();
        articleType.setParent(new ArticleType());
        ArticleTypeExecution articleTypeExecution = articleTypeService.queryArticleType(articleType);
        List<ArticleType> articleTypes = articleTypeExecution.getArticleTypeList();

        modelMap.put("articles", articles);
        modelMap.put("articleTypes", articleTypes);
        modelMap.put("success", true);


        return modelMap;
    }


    @RequestMapping(value = "articleinserttest", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> articleInsertTest(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        String verifyCodeActual = request.getParameter("verifyCodeActual");

        modelMap.put("success", false);
        modelMap.put("msg", verifyCodeActual);
        return modelMap;
    }

}
