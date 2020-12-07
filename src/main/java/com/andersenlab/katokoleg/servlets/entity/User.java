package com.andersenlab.katokoleg.servlets.entity;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedEntityGraph(name = "graph.User.roles", attributeNodes = @NamedAttributeNode("roles"))
@EqualsAndHashCode(of = {"login", "password"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String login;
    private String password;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private Set<UserRole> roles = new HashSet<>();

    public User() {
    }

    public User(String login, String password, UserRole... userRoles) {
        this.login = login;
        this.password = password;
        roles.addAll(Arrays.asList(userRoles));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
