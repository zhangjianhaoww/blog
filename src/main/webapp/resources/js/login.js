$(function () {
    url = 'myblog/admin/checkuser';

    $("#submit").click(function () {
        var user= $("#userName").val();
        var password = $("#password").val();
        var kaptcha = $("#kaptcha").val();
        if(user == null || password == null || kaptcha == null || user == '' || password == '' || kaptcha == ''){
            alert("请输入完整数据！！！");
            return;
        }

        $.post('myblog/admin/checkuser',
            {
                userName:user,
                password:password,
                kaptcha:kaptcha
            },
            function (data) {
                if(data.success){
                    window.location.href='/admin/adminindex';


                  }else{
                       alert(data.errMsg);
                       $("#captcha_img").click();
                }
            }
        );

        // $.ajax({
        //     url:'/admin/checkuser',
        //     type:'post',
        //     data:formData,
        //     processData:false,
        //     success:function (data) {
        //         if(data.success){
        //
        //         }else{
        //             alert(data.errMsg);
        //             $("#captcha_img").click();
        //         }
        //
        //     }
        //
        //
        //
        // });
    });

})

