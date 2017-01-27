package ro.sci.web;

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
import ro.sci.web.dto.PictureLocation;

import java.net.URI;
import java.net.URISyntaxException;

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

        String pictureUrl = restTemplate.getForObject(resourceUri, String.class);

        return ResponseEntity.ok(new PictureLocation(pictureUrl));
    }


}
