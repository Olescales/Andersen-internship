package com.andersenlab.katokoleg.hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserRole {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    @ManyToMany (mappedBy = "roles", fetch = FetchType.EAGER)
    private List<User> users;

    public UserRole() {
    }

    public UserRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;

        UserRole userRole = (UserRole) o;

        if (name != null ? !name.equals(userRole.name) : userRole.name != null) return false;
        return users != null ? users.equals(userRole.users) : userRole.users == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }
}
