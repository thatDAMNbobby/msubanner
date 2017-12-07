package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.Global;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Controller for login.
 */
@Controller
@RequestMapping("/login")
public final class LoginController {

    /**
     * The login handler.
     */
    private SavedRequestAwareAuthenticationSuccessHandler handler =
            new SavedRequestAwareAuthenticationSuccessHandler();

    /**
     * Maps the login form to the login.
     *
     * @return string with value "login"
     */
    @GetMapping
    public String form() {
        return "login";
    }

    /**
     * Method to read in info from login form.
     * @param map takes Map of two Strings
     * @param request HTTPServlet Request
     * @param response HttpServlet response
     * @return ModelAndView of the index page upon good login
     * @throws Exception if improper input is entered
     */
    @PostMapping
    public ModelAndView authenticate(
            @RequestParam final Map<String, String> map,
                        final HttpServletRequest request,
                        final HttpServletResponse response)
            throws Exception {

        String username = map.get("username");
        String password = map.get("password");

        if (username.equals("user") && password.equals("password")) {

            Authentication result = new UsernamePasswordAuthenticationToken(
                username, "N/A",
                AuthorityUtils.commaSeparatedStringToAuthorityList(
                        "ROLE_USER"));

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
