package com.bn.demoProject.Controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.ErrorHandler;

@RestController
public class ErrorHandlerController implements ErrorController {
    public static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public ResponseEntity<?>error()
    {
        return ResponseEntity.badRequest().body("Въвели сте грешен адрес!");
    }
    @Override
    public String getErrorPath()
    {
        return null;
    }
}
