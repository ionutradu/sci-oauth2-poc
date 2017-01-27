package ro.sci.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    @Value("${auth.server.host}")
    private String host;

    @Value("${auth.server.port}")
    private int port;

    @Value("${auth.server.path}")
    private String path;


    @Value("${client.id}")
    private String clientId;

    private String protocol = "http";

    private String url;

    private UriComponentsBuilder uriComponentsBuilder;

    private Map<String, String> authorizedUsers;

    @PostConstruct
    public void init() {
        authorizedUsers = new HashMap<>();

        url = protocol + "://" + host + ":" + port + path;
    }

    public String generateAuthUrl() {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("client_id", clientId)
                .queryParam("response_type", "code")
                .queryParam("callback_uri", "/app/profile/picture")
                .build()
                .encode()
                .toUriString();
    }

    public boolean isUserAuthorized(String user) {
        return authorizedUsers.containsKey(user);
    }

    public String getAuthorizeCode(String user) {
        if (isUserAuthorized(user)) {
            return authorizedUsers.get(user);
        }

        return null;
    }

    public void saveUser(String username, String authorizationCode) {
        authorizedUsers.put(username, authorizationCode);
    }
}
