package com.java.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EmployCrudBean
 */
@Stateless
@Remote(EmployCrudBeanRemote.class)
public class EmployCrudBean implements EmployCrudBeanRemote {

    /**
     * Default constructor. 
     */
    public EmployCrudBean() {
        // TODO Auto-generated constructor stub
    }

}
