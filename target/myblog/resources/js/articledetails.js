// $(function () {
//
//     var articleId = getQueryString("articleId");
//     var url = "/myblog/article/articledetailsinfo?articleId=" + articleId;
//     alert(articleId);
//     getArticleDetails();
//
//     // $.ajax({
//     //     url:url + "?articleId=" + articleId,
//     //     type:"get",
//     //     dataType:"json",
//     //     success:function (data) {
//     //         if(data.success){
//     //             handleList(data.article);
//     //         }
//     //     }
//
//
//     function getArticleDetails() {
//         $.getJSON(url, function (data) {
//             if(data.success){
//                 handleList(data.article)
//             }
//         })
//     }
//
//
// //  $("#content").html(marked(markdownn));
//     function handleList(data) {
//         var article_html = '';
//         article_html += '<article class="am-article blog-article-p">'
//             +'<div class="am-article-hd">'
//             +'<h1 class="am-article-title blog-text-center">我的文章哎</h1>'
//             +'<p class="am-article-meta blog-text-center">'
//             +'<span><a href="#" class="blog-color">article &nbsp;</a></span>-'
//             +'<span><a href="#">@amazeUI &nbsp;</a></span>-'
//             +'<span><a href="#">2015/10/9</a></span>'
//             +'</p>'
//             +'</div>'
//             +'<div class="am-article-bd">'
//             +'<img src="assets/i/f10.jpg" alt="" class="blog-entry-img blog-article-margin">'
//             +'<p class="class="am-article-lead""> 描述：'
//             +'<blockquote><p>' + data.articleDesc + '</p></blockquote>'
//             +'<div id="articleDetails">' + marked(data.articleText) + '</div>'
//             +'</div>'
//             +'</article>';
//
//
//         $("#article_details").html(article_html);
//
//     }
//
// })


$(function () {

    var articleId = getQueryString("articleId");
    var url = "/myblog/article/articledetailsinfo?articleId=" + articleId;

    getArticleDetails();

    // $.ajax({
    //     url:url + "?articleId=" + articleId,
    //     type:"get",
    //     dataType:"json",
    //     success:function (data) {
    //         if(data.success){
    //             handleList(data.article);
    //         }
    //     }


    function getArticleDetails() {
        $.getJSON(url, function (data) {
            if(data.success){
                handleList(data.article);
                hadleArticleParentType(data.parentType);
            }
        })
    }


//  $("#content").html(marked(markdownn));
    function handleList(data) {
        var article_html = '';
        article_html += '<article class="am-article blog-article-p">'
            +'<div class="am-article-hd">'
            +'<h1 class="am-article-title blog-text-center">'+ data.articleName + '</h1>'
            +'<p class="am-article-meta blog-text-center">'
            +'<span><a href="#" class="blog-color">article &nbsp;</a></span>-'
            +'<span><a href="#">@amazeUI &nbsp;</a></span>-'
            +'<span><a href="#">' + new Date(data.articleCreateTime).toLocaleDateString() + '</a></span>'
            +'</p>'
            +'</div>'
            +'<div class="am-article-bd">'
            +'<img src="' + data.articleImage + '"alt="" class="blog-entry-img blog-article-margin">'
            //+'<p class="class="am-article-lead""> 描述：'
            // +'<blockquote><p>' + data.articleDesc + '</p></blockquote>'
            +'<div id="articleDetails">' + marked(data.articleText) + '</div>'
            +'</div>'
            +'</article>'
            +'<div class="am-g blog-article-widget blog-article-margin">'
            +'<div class="am-u-lg-4 am-u-md-5 am-u-sm-7 am-u-sm-centered blog-text-center">'
            +'<span class="am-icon-tags"> &nbsp;</span><a href="#">标签</a> , <a href="#">TAG</a> , <a href="#">啦啦</a>'
            +'<hr>'
            +'</div>'
            +'</div>';



        $("#article_details").html(article_html);



    }

    function hadleArticleParentType(data) {

        var parentTypeHtml = '<li><a href="/myblog/article/index">全部类型</a></li>';
        data.map(function (item, index) {
            parentTypeHtml += '<li><a href="/myblog/article/index?parentTypeId=' + item.articleTypeId +'">' + item.articleTypeName + '</a></li> '

        });
        $("#articleParentTypeaa").html(parentTypeHtml);
    }

})