package net.csdcodes.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * csdcodes.net
 * 2019/11/10
 */
@RestController
public class CookieController {
    @GetMapping("/setcookie")
    private String setCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("sessionId", "CookieTestInfo");
        cookie.setMaxAge(1000);//set expire time to 1000s
        response.addCookie(cookie); //put cookie in response
        return "successfully set cookie";
    }

    @GetMapping("/cookievalue")
    private String cookieValue(@CookieValue(value = "sessionId",  defaultValue = "none") String sessionId){
        return "Cookie Value is " + sessionId;
    }

    @GetMapping("/getcookie")
    private String getCookies(HttpServletRequest request){
        Cookie [] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("sessionId")){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}
