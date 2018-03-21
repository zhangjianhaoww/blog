<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2018/3/9
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>BLOG index with sidebar & slider  | Amaze UI Examples</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="../../../resources/blog/assets/i/favicon.png">
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="../../../resources/blog/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="apple-touch-icon-precomposed" href="../../../resources/blog/assets/i/app-icon72x72@2x.png">
    <meta name="msapplication-TileImage" content="assets/i/app-icon72x72@2x.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
    <link rel="stylesheet" href="../../../resources/blog/assets/css/amazeui.min.css">
    <link rel="stylesheet" href="../../../resources/blog/assets/css/app.css">
    <link rel="stylesheet" href="../../../resources/md/css/am-md.css">
</head>

<body id="blog">
<!--
<header class="am-g am-g-fixed blog-fixed blog-text-center blog-header">
    <div class="am-u-sm-8 am-u-sm-centered">
        <img width="200" src="http://s.amazeui.org/media/i/brand/amazeui-b.png" alt="Amaze UI Logo"/>
        <h2 class="am-hide-sm-only">中国首个开源 HTML5 跨屏前端框架</h2>
    </div>
</header>
-->
<hr>
<!-- nav start -->
<nav class="am-g am-g-fixed blog-fixed blog-nav">
    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only blog-button" data-am-collapse="{target: '#blog-collapse'}" ><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="blog-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav">
            <li class="am-active"><a href="/article/index">首页</a></li>
            <li class="am-dropdown" data-am-dropdown>
                <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                    文章分类 <span class="am-icon-caret-down"></span>
                </a>
                <ul class="am-dropdown-content" id="articleParentType">

                </ul>
            </li>
            <li><a href="lw-article.html">标准文章</a></li>
            <li><a href="lw-img.html">图片库</a></li>
            <li><a href="lw-article-fullwidth.html">全宽页面</a></li>
            <li><a href="lw-timeline.html">存档</a></li>
        </ul>
        <form class="am-topbar-form am-topbar-right am-form-inline" role="search">
            <div class="am-form-group">
                <input type="text" class="am-form-field am-input-sm" placeholder="搜索">
            </div>
        </form>
    </div>
</nav>
<hr>
<!-- nav end -->
<!-- banner start -->
<div class="am-g am-g-fixed blog-fixed am-u-sm-centered blog-article-margin">
    <div data-am-widget="slider" class="am-slider am-slider-b1" data-am-slider='{&quot;controlNav&quot;:false}' >
        <ul class="am-slides">
            <li>
                <img src="../../../resources/blog/assets/i/b1.jpg">
                <div class="blog-slider-desc am-slider-desc ">
                    <div class="blog-text-center blog-slider-con">
                        <span><a href="" class="blog-color">Article &nbsp;</a></span>
                        <h1 class="blog-h-margin"><a href="">总在思考一句积极的话</a></h1>
                        <p>那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。
                        </p>
                        <span class="blog-bor">2015/10/9</span>
                        <br><br><br><br><br><br><br>
                    </div>
                </div>
            </li>

            <li>
                <img src="../../../resources/blog/assets/i/b2.jpg">
                <div class="am-slider-desc blog-slider-desc">
                    <div class="blog-text-center blog-slider-con">
                        <span><a href="" class="blog-color">Article &nbsp;</a></span>
                        <h1 class="blog-h-margin"><a href="">总在思考一句积极的话</a></h1>
                        <p>那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。
                        </p>
                        <span>2015/10/9</span>
                    </div>
                </div>
            </li>
            <li>
                <img src="../../../resources/blog/assets/i/b3.jpg">
                <div class="am-slider-desc blog-slider-desc">
                    <div class="blog-text-center blog-slider-con">
                        <span><a href="" class="blog-color">Article &nbsp;</a></span>
                        <h1 class="blog-h-margin"><a href="">总在思考一句积极的话</a></h1>
                        <p>那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。
                        </p>
                        <span>2015/10/9</span>
                    </div>
                </div>
            </li>
            <li>
                <img src="../../../resources/blog/assets/i/b2.jpg">
                <div class="am-slider-desc blog-slider-desc">
                    <div class="blog-text-center blog-slider-con">
                        <span><a href="" class="blog-color">Article &nbsp;</a></span>
                        <h1 class="blog-h-margin"><a href="">总在思考一句积极的话</a></h1>
                        <p>那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。
                        </p>
                        <span>2015/10/9</span>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>
<!-- banner end -->

<!-- content srart -->
<div class="am-g am-g-fixed blog-fixed">
    <div class="am-u-md-8 am-u-sm-12">

        <article class="am-g blog-entry-article">
            <div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">
                <img src="../../../resources/blog/assets/i/f10.jpg" alt="" class="am-u-sm-12">
            </div>
            <div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">
                <span><a href="" class="blog-color">article &nbsp;</a></span>
                <span> @amazeUI &nbsp;</span>
                <span>2015/10/9</span>
                <h1><a href="">我本楚狂人，凤歌笑孔丘</a></h1>
                <p>我们一直在坚持着，不是为了改变这个世界，而是希望不被这个世界所改变。
                </p>
                <p><a href="" class="blog-continue">continue reading</a></p>
            </div>
        </article>

        <div id="article-wrap"></div>

        <ul class="am-pagination">
            <li class="am-pagination-prev"><button href=""  id="prevClick">&laquo; Prev</button></li>
            <li class="am-pagination-next"><button href="" id="nextClick">Next &raquo;</button></li>
        </ul>
    </div>

    <div class="am-u-md-4 am-u-sm-12 blog-sidebar">
        <div class="blog-sidebar-widget blog-bor">
            <h2 class="blog-text-center blog-title"><span>About ME</span></h2>
            <div id="userDetails"></div>
        </div>
        <!--div class="blog-sidebar-widget blog-bor">
            <h2 class="blog-text-center blog-title"><span>Contact ME</span></h2>
            <p>
                <a href=""><span class="am-icon-qq am-icon-fw am-primary blog-icon"></span></a>
                <a href=""><span class="am-icon-github am-icon-fw blog-icon"></span></a>
                <a href=""><span class="am-icon-weibo am-icon-fw blog-icon"></span></a>
                <a href=""><span class="am-icon-reddit am-icon-fw blog-icon"></span></a>
                <a href=""><span class="am-icon-weixin am-icon-fw blog-icon"></span></a>
            </p>
        </div-->
        <div class="blog-clear-margin blog-sidebar-widget blog-bor am-g ">
            <h2 class="blog-title"><span>TAG cloud</span></h2>
            <div class="am-u-sm-12 blog-clear-padding">
                <a href="" class="blog-tag">amaze</a>
                <a href="" class="blog-tag">妹纸 UI</a>
                <a href="" class="blog-tag">HTML5</a>
                <a href="" class="blog-tag">这是标签</a>
                <a href="" class="blog-tag">Impossible</a>
                <a href="" class="blog-tag">开源前端框架</a>
            </div>
        </div>
        <div class="blog-sidebar-widget blog-bor">
            <h2 class="blog-title"><span>么么哒</span></h2>
            <ul class="am-list">
                <li><a href="#">每个人都有一个死角， 自己走不出来，别人也闯不进去。</a></li>
                <li><a href="#">我把最深沉的秘密放在那里。</a></li>
                <li><a href="#">你不懂我，我不怪你。</a></li>
                <li><a href="#">每个人都有一道伤口， 或深或浅，盖上布，以为不存在。</a></li>
            </ul>
        </div>
    </div>
</div>
<!-- content end -->



<footer class="blog-footer">
    <div class="am-g am-g-fixed blog-fixed am-u-sm-centered blog-footer-padding">
        <div class="am-u-sm-12 am-u-md-4- am-u-lg-4">
            <h3>模板简介</h3>
            <p class="am-text-sm">这是一个使用amazeUI做的简单的前端模板。<br> 博客/ 资讯类 前端模板 <br> 支持响应式，多种布局，包括主页、文章页、媒体页、分类页等<br>嗯嗯嗯，不知道说啥了。外面的世界真精彩<br><br>
                Amaze UI 使用 MIT 许可证发布，用户可以自由使用、复制、修改、合并、出版发行、散布、再授权及贩售 Amaze UI 及其副本。</p>
        </div>
        <div class="am-u-sm-12 am-u-md-4- am-u-lg-4">
            <h3>社交账号</h3>
            <p>
                <a href=""><span class="am-icon-qq am-icon-fw am-primary blog-icon blog-icon"></span></a>
                <a href=""><span class="am-icon-github am-icon-fw blog-icon blog-icon"></span></a>
                <a href=""><span class="am-icon-weibo am-icon-fw blog-icon blog-icon"></span></a>
                <a href=""><span class="am-icon-reddit am-icon-fw blog-icon blog-icon"></span></a>
                <a href=""><span class="am-icon-weixin am-icon-fw blog-icon blog-icon"></span></a>
            </p>
            <h3>Credits</h3>
            <p>我们追求卓越，然时间、经验、能力有限。Amaze UI 有很多不足的地方，希望大家包容、不吝赐教，给我们提意见、建议。感谢你们！</p>
        </div>
        <div class="am-u-sm-12 am-u-md-4- am-u-lg-4">
            <h1>我们站在巨人的肩膀上</h1>
            <h3>Heroes</h3>
            <p>
            <ul>
                <li>jQuery</li>
                <li>Zepto.js</li>
                <li>Seajs</li>
                <li>LESS</li>
                <li>...</li>
            </ul>
            </p>
        </div>
    </div>
    <div class="blog-text-center">© 2015 AllMobilize, Inc. Licensed under MIT license. Made with love By LWXYFER</div>
</footer>

<div data-provide="am-md-editable">
    <h3>amazeui 啦啦啦啦阿拉啦</h3>
    <p>通过 "data-provide = am-md-editable" 调用MD编辑器</p>
</div>



<!--[if (gte IE 9)|!(IE)]><!-->
<script src="../../../resources/blog/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="../../../resources/blog/assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script src="../../../resources/blog/assets/js/amazeui.min.js"></script>
<script src="../../../resources/md/js/md.js"></script>
<script src="../../../resources/md/js/tomd.js"></script>
<script src="../../../resources/md/js/am-md.js"></script>
<script src="../../../resources/js/common/commons.js"></script>

<!-- index.js -->
<script>
    $(function () {
        var pageCount = 1;
        var articleCount = 0;
        var parentTypeId = getQueryString("parentTypeId");
        alert(parentTypeId);
        getArticleList();

        function getArticleList() {
            $.ajax({
                url:"/article/articleindexinfo?pageCount=" + pageCount,
                type:"get",
                dataType:"json",
                success:function (data) {
                    if(data.success) {
                        articleCount = data.articleCount;
                        handleList(data.articleList);
                        handleUser(data.user);
                        hadleArticleParentType(data.firstType);
                    }
                }

            })

        }

        function handleList(data) {
            var html = '';
            data.map(function (item, index) {
                html += ' <article class="am-g blog-entry-article">'
                    + '<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">'
                    + '<img src="' + item.articleImage + '" alt="" class="am-u-sm-12">'
                    + '</div>'
                    + '<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">'
                    + '<span><a href="" class="blog-color">'+ item.articleType.articleTypeName +' &nbsp;</a></span>'
                    + '<span> @' + item.articleOwner.userName +' &nbsp;</span>'
                    + '<span>'+ new Date(item.articleCreateTime).toLocaleDateString() +'</span>'
                    + ' <h1><a href="' + '/article/articledetails?articleId=' + item.articleId +'">' +  item.articleName +'</a></h1>'
                    + '<p>' +  item.articleDesc +'</p>'
                    + '<p><a href="" class="blog-continue">continue reading</a></p>'
                    + '</div>'
                    + '</article>';

            });

            $("#article-wrap").html(html);
        }

        $("#prevClick").click(function () {
            if(pageCount == 1){
                alert("已经是第一页！！");
                return;
            }
            else{
                pageCount -= 1;
                getArticleList();
            }
        })

        $("#nextClick").click(function () {
            if((articleCount - pageCount* 10) <=  0){
                return;
            }
            else{
                pageCount += 1;
                getArticleList();
            }
        })


        function nextClick() {
            if((articleCount - pageCount* 10) <=  0){
                return;
            }
            else{
                pageCount += 1;
                getArticleList();
            }
        }

        function handleUser(data) {
            var userHtml = '';
            userHtml +='<img src="' + data.userImage +'" alt="about me" class="blog-entry-img" >'
                +'<p>' + data.userName + '</p>'
                +'<p>' + data.userDesc + '</p>';
            $("#userDetails").html(userHtml);
        }

        function hadleArticleParentType(data) {

            var parentTypeHtml = '';
            data.map(function (item, index) {
                parentTypeHtml += '<li><a href="/article/index?parentTypeId=' + item.articleTypeId +'">' + item.articleTypeName + '</a></li> '

            });
            $("#articleParentType").html(parentTypeHtml);
        }
    })
</script>
</body>
</html>