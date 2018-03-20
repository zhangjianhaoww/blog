$(function () {

    var articleId = getQueryString("articleId");
    var url = "article/articledetailsinfo?articleId=" + articleId;
    alert(articleId);
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
                handleList(data.article)
            }
        })
    }


//  $("#content").html(marked(markdownn));
    function handleList(data) {
        var article_html = '';
        article_html += '<article class="am-article blog-article-p">'
            +'<div class="am-article-hd">'
            +'<h1 class="am-article-title blog-text-center">我的文章哎</h1>'
            +'<p class="am-article-meta blog-text-center">'
            +'<span><a href="#" class="blog-color">article &nbsp;</a></span>-'
            +'<span><a href="#">@amazeUI &nbsp;</a></span>-'
            +'<span><a href="#">2015/10/9</a></span>'
            +'</p>'
            +'</div>'
            +'<div class="am-article-bd">'
            +'<img src="assets/i/f10.jpg" alt="" class="blog-entry-img blog-article-margin">'
            +'<p class="class="am-article-lead""> 描述：'
            +'<blockquote><p>' + data.articleDesc + '</p></blockquote>'
            +'<div id="articleDetails">' + marked(data.articleText) + '</div>'
            +'</div>'
            +'</article>';


        $("#article_details").html(article_html);

    }

})
