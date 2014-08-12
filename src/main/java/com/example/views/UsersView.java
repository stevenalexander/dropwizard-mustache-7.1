package com.example.views;

import com.example.core.User;
import io.dropwizard.views.View;

import java.util.List;

public class UsersView extends View {
    private final List<User> users;

    public UsersView(List<User> users) {
        super("Users.mustache");
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
