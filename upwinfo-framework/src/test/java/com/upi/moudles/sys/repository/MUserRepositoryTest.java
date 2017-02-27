package com.upi.moudles.sys.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.upi.moudles.sys.domain.MUser;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MUserRepositoryTest {

    private static Logger log = LoggerFactory.getLogger(MUserRepositoryTest.class);

    @Autowired
    private MUserRepository userRepo;

    @Test
    public void shouldSaveFoo() {
        int countBefore = userRepo.findAll().size();
        try {
            MUser foo = new MUser();
            foo.setUserCd("foo");
            userRepo.saveAndFlush(foo);
        } catch (Exception e) {
            log.error("Error saving Foo.", e);
            throw e;
        }
        int countAfter = userRepo.findAll().size();
        assertEquals(1, countAfter - countBefore);
    }

}
