package ro.sci.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;

@Service
public class ResourceService {

    @Value("${auth.server.host}")
    private String host;

    @Value("${auth.server.port}")
    private int port;

    private static final String RESOURCE_PATH = "/AuthorizationResourceServer/webresources/profile/resource";

    private String protocol = "http";

    private URI uri;

    private UriComponentsBuilder uriComponentsBuilder;

    private String resourceUrl;

    @PostConstruct
    public void init() {
        resourceUrl = protocol + "://" + host + ":" + port + RESOURCE_PATH;
    }

    public URI getResourceUri(String authorizationCode) {
        return UriComponentsBuilder.fromHttpUrl(resourceUrl)
                .queryParam("authorization_code", authorizationCode)
                .build()
                .toUri();
    }
}
