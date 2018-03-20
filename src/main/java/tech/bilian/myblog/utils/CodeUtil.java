package tech.bilian.myblog.utils;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
    public static boolean ckechVerifyCode(HttpServletRequest request, String verifyCodeActual){
        String verifyCodeExpected = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);

        if(verifyCodeActual != null && verifyCodeActual.toLowerCase().equals(verifyCodeExpected.toLowerCase())){
            return true;
        }
        return false;
    }
}
