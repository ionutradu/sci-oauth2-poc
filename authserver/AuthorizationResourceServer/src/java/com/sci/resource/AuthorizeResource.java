/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sci.resource;

import com.sci.general.Constants;
import com.sci.general.UserDetails;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author gabi
 */
@Path("/manage/oauth2/token")
public class AuthorizeResource {

    @Context
    private UriInfo context;
    
    @Context
    private HttpServletRequest request;
    @Context 
    private HttpServletResponse response;

    /**
     * Creates a new instance of ItemsResource
     */
    

    /**
     * Retrieves representation of an instance of com.sci.resource.AuthorizeResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getJson(@QueryParam("client_id") String client_id, 
                            @QueryParam("response_type") String response_type, 
                            @QueryParam("callback_uri") String callback_uri,
                            @QueryParam("username") String username,
                            @QueryParam("password") String password) throws JSONException, URISyntaxException, ServletException, IOException {
        
        if(client_id == null || response_type == null || callback_uri == null) { 
            
            return Response.status(Status.BAD_REQUEST).build(); 
        }
        
        if(username == null || password == null) {

            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
            response.setHeader("Access-Control-Max-Age", "1209600");
            
            request.getRequestDispatcher("/index.jsp?client_id=" + client_id + "&response_type=" + response_type + "&callback_uri=" + callback_uri).forward(request, response);
            
            return Response.status(Status.OK).build();  
        }
        
        if(!Constants.checkUser(username, password)) {
            return Response.status(Status.UNAUTHORIZED).build();
        }
        
        switch(response_type) {
            case "code" : {
                if(Constants.clients.containsKey(client_id)) {
                    String authorizationCode = Constants.generateAuthorizationCode(client_id, callback_uri, username);
                    URI redirect_uri = new URI(Constants.clients.get(client_id).getCallback_uri() + "?authorization_code=" + authorizationCode + "&username=" + username);
                    return Response.temporaryRedirect(redirect_uri).build();
                } else {
                    return Response.status(Status.UNAUTHORIZED).build();
                }
            }
        }
        
        return Response.status(Status.BAD_REQUEST).build(); 
    }
    
}
