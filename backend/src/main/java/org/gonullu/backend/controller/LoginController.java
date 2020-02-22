package org.gonullu.backend.controller;

import org.gonullu.backend.service.UserService;
import org.gonullu.backend.ws.model.request.UserDetailsRequestModel;
import org.gonullu.backend.ws.model.response.UserRest;
import org.gonullu.backend.ws.shared.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController()
public class LoginController {

    @Autowired
    UserService userService;

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);
    public static final String SECURED_TEXT = "Hello from the secured resource!";

    @RequestMapping(path="/login", method = RequestMethod.GET)
    public @ResponseBody String getSecured() {
        LOG.info("GET successfully called on /secured resource");
        return SECURED_TEXT;
    }

    // Forwards all routes to FrontEnd except: '/', '/index.html', '/api', '/api/**'
    //All paths which is not defined in app forwards to home page .
    // Required because of 'mode: history' usage in frontend routing, see README for further details
    @RequestMapping(value = "{_:^(?!index\\.html|api).$}")
    public String redirectApi() {
        LOG.info("URL entered directly into the Browser, so we need to redirect...");
        return "forward:/";
    }

}
