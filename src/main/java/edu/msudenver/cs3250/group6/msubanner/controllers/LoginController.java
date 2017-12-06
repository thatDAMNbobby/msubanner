package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.Global;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Controller for login.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private SavedRequestAwareAuthenticationSuccessHandler handler =
            new SavedRequestAwareAuthenticationSuccessHandler();

    @GetMapping
    public String form() {
        return "login";
    }

    // For some reason, successful logins map to "http://localhost:8080/static/css/style.css"
    // TODO: See if we can redirect to some other page on success.
    @PostMapping
    public ModelAndView authenticate(@RequestParam final Map<String, String> map,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {

        String username = map.get("username");
        String password = map.get("password");


        if (username.equals("user") && password.equals("password")) {

            Authentication result = new UsernamePasswordAuthenticationToken(
                    username, "N/A",
                    AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));

            SecurityContextHolder.getContext().setAuthentication(result);

            ModelAndView mav = new ModelAndView("index");
            mav.addObject("school_name", Global.SCHOOL_NAME);
            handler.onAuthenticationSuccess(request, response, result);
            return mav;

        } else {
            throw new BadCredentialsException("Invalid username or password!");
        }
    }

}
