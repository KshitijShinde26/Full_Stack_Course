package com.basic_spring.demo.services;

import java.io.Serializable;

public interface GrantedAuthority extends Serializable {

    String getAuthority();
}
