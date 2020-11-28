package com.andersenlab.katokoleg.hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserRole {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated (EnumType.STRING)
    private Role role;

    @ManyToMany (mappedBy = "roles", fetch = FetchType.EAGER)
    private List<User> users;

    public UserRole() {
    }

    public UserRole(Role role) {
        this.role = role;
    }
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;

        UserRole userRole = (UserRole) o;

        return role == userRole.role;
    }

    @Override
    public int hashCode() {
        return role != null ? role.hashCode() : 0;
    }
}
