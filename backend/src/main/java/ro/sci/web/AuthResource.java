package ro.sci.web;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ro.sci.service.AuthService;
import ro.sci.service.ResourceService;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/app")
public class AuthResource {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private AuthService authService;

    @Autowired
    private RestTemplate restTemplate;

    @CrossOrigin
    @RequestMapping("/auth")
    public ResponseEntity<Void> saveAuthorizationCode(@NotEmpty @RequestParam String authorization_code,
                                                      @NotEmpty @RequestParam String username) throws URISyntaxException {

        authService.saveUser(username, authorization_code);

        return ResponseEntity.ok().build();
    }
}
