package ro.sci.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ro.sci.service.AuthService;
import ro.sci.service.ResourceService;
import ro.sci.web.dto.PictureLocation;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/app")
public class UserResource {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private AuthService authService;

    @Autowired
    private RestTemplate restTemplate;

    @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping("/profile/picture")
    public ResponseEntity<PictureLocation> getProfilePicture(@RequestParam(required = false) String authorization_code) throws URISyntaxException {

        if (StringUtils.isEmpty(authorization_code)) {
            String redirectUrl = authService.generateAuthUrl();
            return ResponseEntity
                    .status(HttpStatus.TEMPORARY_REDIRECT)
                    .location(new URI(redirectUrl))
                    .build();
        }

        URI resourceUri = resourceService.getResourceUri(authorization_code);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.ALL));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<PictureLocation> exchange = restTemplate.exchange(resourceUri, HttpMethod.GET, entity, PictureLocation.class);

        return ResponseEntity.ok(exchange.getBody());
    }
}
