/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upi.moudles.sys.service;

import com.upi.moudles.sys.domain.MUser;
import com.upi.moudles.sys.repository.MUserRepositoryTest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author hang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {
    private static Logger log = LoggerFactory.getLogger(UserServiceTest.class);
    
    @Autowired
    private UserService userService;
    
    /**
     * Test of insertUserAndCode method, of class UserService.
     */
    @Test
    public void testInsertUserAndCode() {
        userService.insertUserAndCode("BaseService", "TCODE1");
        System.out.println("execude insert method.");
    }
    
    @Test
    public void testGetUsers() {
        Page<MUser> users = userService.users();
        System.out.println("Fetch user information.");
    }
    
}
