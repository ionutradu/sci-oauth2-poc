/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sci.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import com.sci.general.Constants;
import java.net.URISyntaxException;
/**
 *
 * @author gabi
 */
@Path("/profile/resource")
public class ProfileResource {
    
    @Context
    private UriInfo context;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getJson(@QueryParam("authorization_code") String authorization_code) throws URISyntaxException {
        
        if(!Constants.authorizationCodeUsername.containsKey(authorization_code)) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        
        String username = Constants.authorizationCodeUsername.get(authorization_code);
        URI profilePicture = new URI(Constants.users.get(username).getProfilePicture());
        
        return Response.temporaryRedirect(profilePicture).build();
    }
}
