$(function () {
    var url = "myblog/admin/admininitinfo";
    var articlePage = 1;
    var articleType = null;
    var pageCount = 1;
    $("#buttonfull").click();

    getAdminInitInfo(articlePage, articleType);




    function getAdminInitInfo(articlePage, articleType) {
        $.getJSON(url,
            {
                articlePage:articlePage,
                articleType:articleType
            },

            function (data) {
            if(data.success){
                setAtricleInfo(data.articles);
            }

        })
    }

    function setAtricleInfo(data) {
        var html = '';
        data.map(function (item, index) {
            html += '<tr>'
                +'<td>'+ item.articleId + '</td>'
                +'<td><a href="/article/articledetails?articleId=' + item.articleId +'">' + item.articleName + '</a></td>'
                +'<td>' + item.articleId +'</td>' //item.articleType
                +'<td class="am-hide-sm-only">' + item.articleId +'</td>' //item.articleOwner.userName
                +' <td class="am-hide-sm-only">' + item.articleLastEditTime +'</td>'
                +'<td>'
                +'<div class="am-btn-toolbar">'
                +'<div class="am-btn-group am-btn-group-xs">'
                +'<a class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</a>'
                +'<a class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</a>'
                +'</div>'
                +'</div>'
                +' </td>'
                +'</tr>'
        })
        $("#articleInfo").html(html);
    }

})