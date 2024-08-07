package com.ohgiraffers.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {

    @GetMapping("controller-null")
    public String nullPointerExceptionTest() {

        String str = null;
        System.out.println(str.charAt(0));

        return "/";

    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException exception) {

        System.out.println("controller 레벨의 exception 처리");

        return "error/nullPointer";
    }

    @GetMapping("controller-user")
    public String userExceptionTest() throws MemberRegisterException {

        boolean check = true;

        if(check) {
            throw new MemberRegisterException("당신같은 사람은 회원으로 받을 수 없습니다.");
        }
        return "/";
    }

    @ExceptionHandler(MemberRegisterException.class)
    public String userExceptionHandler(Model model, MemberRegisterException exception) {
        System.out.println("Controller 레벨의 Exception 처리");
        model.addAttribute("exception", exception);

        return "error/memberRegist";
    }
}
