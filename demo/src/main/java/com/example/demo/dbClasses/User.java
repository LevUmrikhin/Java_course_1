package com.example.demo.dbClasses;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Column;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    private boolean enabled;
    @Transient
    public List<Authority> authorities = new ArrayList<Authority>();
    
    // Прочие необходимые поля (например, роли)

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Верните список ролей/прав доступа, например:
       List<SimpleGrantedAuthority> result = new ArrayList<SimpleGrantedAuthority>();
        for (Authority authority : authorities) { result.add(new SimpleGrantedAuthority(authority.authority)); }
        return result;
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
