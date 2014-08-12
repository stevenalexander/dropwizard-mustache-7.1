package com.example.resources;

import com.example.core.User;
import com.example.views.UsersView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

@Path("/user")
@Produces(MediaType.TEXT_HTML)
public class UserResource {

    @GET
    public UsersView getAll(){

        List<User> users = new LinkedList<>();
        users.add(
            new User()
                .setUsername("user1")
                .setDisplayName("User 1")
                .setDisplayRole("Admin")
        );
        users.add(
            new User()
                .setUsername("user2")
                .setDisplayName("User 2")
                .setDisplayRole("DBA")
        );

        return new UsersView(users);
    }
}
