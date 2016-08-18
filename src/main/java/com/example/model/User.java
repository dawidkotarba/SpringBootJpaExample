package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "PK", sequenceName = "USERS_SEQ", allocationSize = 1)
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "PK", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
