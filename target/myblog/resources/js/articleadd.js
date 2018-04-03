$(function(){

    var textt;
    alert("dfljsfkdsflzhangjiana");
    var markdownn = "> 引用：Amaze ~ 妹子 UI -- 中国首个开源 HTML5 跨屏前端框架 ![](./images/01.jpg)";
    getInsertPageInitInfo();

  //  $("#content").html(marked(markdownn));

    $("#test").markdown({

        savable:true,
        onSave: function(e) {
            alert("Saving '"+e.getContent()+"'...")
            textt = e.getContent();
        },
        onChange: function(e){
            console.log("Changed!")
        }
    })

    $("#submit").click(function () {
        if(textt == null){
           alert("文章内容不能为空");
            return;
        }
        var article = {};
        article.articleName = $("#title").val();
        //article.author = $("#author").val();
        article.articleDesc = $("#desc").val();
        //article.type = $("#type").val();
        article.articleText=textt;
        article.articlePriority = $("#articlePriority").val();
        article.articleType = {
            articleTypeId : $('#articleType').find('option').not(function() {
                return !this.selected;
            }).data('id')
        }
        var isShow = $("#isShow").val();
        alert(isShow);
        var verifyCodeActual = $("#j_captcha").val();
        if(!verifyCodeActual){
            alert("请输入验证码！！！");
            return;
        }
        var articleImg = $('#image')[0].files[0];
        var formData = new FormData();
        formData.append('articleImg', articleImg);
        formData.append("article", JSON.stringify(article));
        formData.append("verifyCodeActual", verifyCodeActual);

        $.ajax({
            // url : (isEdit ? editShopUrl : registerShopUrl),
            url:  'myblog/admin/articleinsert',
            type : 'post',
            data : formData,
            contentType : false,
            processData : false,
            cache : false,
            success : function(data) {
                if (data.success) {
                    alert(data.successMsg);
                    // if (!isEdit) {
                    //     // 若为注册操作，成功后返回店铺列表页
                    //     window.location.href = "/o2o/shopadmin/shoplist";
                    // }
                } else {
                    alert("提交失败！！！" + data.errMsg);
                }
                // 点击验证码图片的时候，注册码会改变
                $('#captcha_img').click();
            }
        });

    })

    function getInsertPageInitInfo() {
        $.getJSON("myblog/admin/getinsertpageinitinfo", function (data) {
            if(data.success){
                insertType(data.articleTypeList);

            }
        })

    }

    function insertType(data) {
        var typeHtml = '';
        data.map(function (item, index) {
            typeHtml += '<option data-id="' + item.articleTypeId
                + '">' + item.articleTypeName + '</option>';
        })
        $("#articleType").html(typeHtml);
    }

});


//实现实时预览的函数
function preview(file) {
    var prevDiv = document.getElementById('preview');
    if (file.files && file.files[0]) {
        var reader = new FileReader();
        reader.onload = function (evt) {
            prevDiv.innerHTML = '<img src="' + evt.target.result + '" />';
        }
        reader.readAsDataURL(file.files[0]);
    } else {
        prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
    }
}