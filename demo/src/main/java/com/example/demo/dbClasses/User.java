package com.example.demo.dbClasses;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;


import java.util.Collection;

@Entity
public class User implements UserDetails {

    @Id
    private int user_id;
    
    @Column
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    private boolean enabled;
    
    // Прочие необходимые поля (например, роли)

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Верните список ролей/прав доступа, например:
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
