$(function () {
    var url = '/article/articlepageinfo';
    var pageCount = 1;
    var articleCount = 0;

    getArticleList();

    function getArticleList() {
        $.ajax({
            url:url + '?pageCount=' + pageCount,
            type:"get",
            dataType:"json",
            success:function (data) {
                if(data.success) {
                    articleCount = data.articleCount;
                    handleList(data.articleList);
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
                + '<span><a href="" class="blog-color">article &nbsp;</a></span>'
                + '<span> @' + item.articleName +' &nbsp;</span>'
                + '<span>'+ item.articleCreateTime +'</span>'
                + ' <h1><a href="">' +  item.articleName +'</a></h1>'
                + '<p>' +  item.articleDesc +'</p>'
                + '<p><a href="" class="blog-continue">continue reading</a></p>'
                + '</div>'
                + '</article>';

        });

        $("#article-wrap").html(html);
    }
})