package com.example;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JpaDemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    private final String TEST_USERNAME = "testUser";
    private final String TEST_PWD = "testPwd";
    private final boolean TEST_IS_ENABLED = true;


    @Test
    public void addUser() {
        // given
        List<User> testUsers = userRepository.findByUsername(TEST_USERNAME);
        assertTrue(testUsers.isEmpty());

        final User newUser = new User();
        newUser.setUsername(TEST_USERNAME);
        newUser.setPassword(TEST_PWD);
        newUser.setEnabled(TEST_IS_ENABLED);

        // when
        userRepository.save(newUser);

        // then
        testUsers = userRepository.findByUsername(TEST_USERNAME);
        assertFalse(testUsers.isEmpty());

        final User savedUser = userRepository.findByUsername(TEST_USERNAME).get(0);
        assertEquals(TEST_USERNAME, savedUser.getUsername());
        assertEquals(TEST_PWD, savedUser.getPassword());
        assertEquals(TEST_IS_ENABLED, savedUser.isEnabled());
    }

    @Test
    public void testIfUserIsAddedByScript() {
        // when
        List<User> all = userRepository.findAll();

        // then
        assertFalse(all.isEmpty());
        assertEquals(2, all.size());
    }
}
