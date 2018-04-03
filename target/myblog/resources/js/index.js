// $(function () {
//     var url = '/myblog/article/articlepageinfo';
//     var pageCount = 1;
//     var articleCount = 0;
//
//     getArticleList();
//
//     function getArticleList() {
//         $.ajax({
//             url:url + '?pageCount=' + pageCount,
//             type:"get",
//             dataType:"json",
//             success:function (data) {
//                 if(data.success) {
//                     articleCount = data.articleCount;
//                     handleList(data.articleList);
//                 }
//             }
//
//         })
//
//     }
//
//     function handleList(data) {
//         var html = '';
//         data.map(function (item, index) {
//             html += ' <article class="am-g blog-entry-article">'
//                 + '<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">'
//                 + '<img src="' + item.articleImage + '" alt="" class="am-u-sm-12">'
//                 + '</div>'
//                 + '<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">'
//                 + '<span><a href="" class="blog-color">article &nbsp;</a></span>'
//                 + '<span> @' + item.articleName +' &nbsp;</span>'
//                 + '<span>'+ item.articleCreateTime +'</span>'
//                 + ' <h1><a href="">' +  item.articleName +'</a></h1>'
//                 + '<p>' +  item.articleDesc +'</p>'
//                 + '<p><a href="" class="blog-continue">continue reading</a></p>'
//                 + '</div>'
//                 + '</article>';
//
//         });
//
//         $("#article-wrap").html(html);
//     }
// })

$(function () {
    var pageCount = 1;
    var articleCount = 0;
    var parentTypeId = getQueryString("parentTypeId");
    var typeId = getQueryString("typeId");
    getArticleList(pageCount, parentTypeId, typeId);

    function getArticleList(pageCount, parentTypeId, typeId) {
        $.ajax({
            url:"/myblog/article/articleindexinfo",
            type:"get",
            data:{
                pageCount:pageCount,
                parentTypeId:parentTypeId,
                typeId:typeId
            },
            dataType:"json",
            success:function (data) {
                if(data.success) {
                    articleCount = data.articleCount;
                    handleList(data.articleList);
                    handleUser(data.user);
                    hadleArticleParentType(data.firstType);
                    hadleArticleType(data.secondType);
                }
            }

        })

    }

    function hadleArticleType(data) {
        var html = '';
        data.map(function (item, index) {
            html += '<a href="myblog/article/index?typeId=' + item.articleTypeId + '" class="blog-tag">' + item.articleTypeName + '</a>';
        });
        $("#tagCloud").html(html);
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
                + ' <h1><a href="' + '/myblog/article/articledetails?articleId=' + item.articleId +'">' +  item.articleName +'</a></h1>'
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
            getArticleList(pageCount, parentTypeId, typeId);
        }
    })

    $("#nextClick").click(function () {
        if((articleCount - pageCount* 10) <=  0){
            return;
        }
        else{
            pageCount += 1;
            getArticleList(pageCount, parentTypeId, typeId);
        }
    })


    function nextClick() {
        if((articleCount - pageCount* 10) <=  0){
            return;
        }
        else{
            pageCount += 1;
            getArticleList(pageCount, parentTypeId, typeId);
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

        var parentTypeHtml = '<li><a href="/myblog/article/index">全部类型</a></li>';
        data.map(function (item, index) {
            parentTypeHtml += '<li><a href="/myblog/article/index?parentTypeId=' + item.articleTypeId +'">' + item.articleTypeName + '</a></li> '

        });
        $("#articleParentType").html(parentTypeHtml);
    }
})