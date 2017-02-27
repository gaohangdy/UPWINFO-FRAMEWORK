/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upi.moudles.biz.repository;

import com.upi.moudles.sys.repository.MUserRepository;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author hang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MCodeRepositoryTest {
    
    private static Logger log = LoggerFactory.getLogger(MCodeRepositoryTest.class);

    @Autowired
    private MUserRepository codeRepo;

    @Test
    public void testSomeMethod() {
        int countBefore = codeRepo.findAll().size();
        assertEquals(1, countBefore);
    }
    
}
