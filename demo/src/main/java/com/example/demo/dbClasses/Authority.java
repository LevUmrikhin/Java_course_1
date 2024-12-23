
package com.example.demo.dbClasses;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



//@Entity
//@Table(name = "authorities")
public class Authority {
    
    //@Column(name = "authority")
    public String authority;
    //@Id
    //@Column(name = "username")
    public String username;

      public Authority(String username, String authority){
        this.username= username;
        this.authority= authority;
    }

}

