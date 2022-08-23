package com.tweetApp.comp2.ControllerTests;

import com.tweetApp.comp2.model.User;
import com.tweetApp.comp2.service.RegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerTests {
    private static final User TESTUSER = new User(0,"testuser@test.com","Test","User",00-00-0000,"neutral","testpassword","testpassword",0);

    @MockBean
    RegisterService rService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testUserController() throws Exception {
        when(rService.registerUSer(TESTUSER))
                .thenReturn(new ResponseEntity<>("user added successfully", HttpStatus.CREATED));
        this.mockMvc.perform(post("/api/v1.0/tweets/register")
                .param(null)
//                .param(PASSWORD, TESTPASSWORD))
//                .andDo(print())
                .andExpect(status().isCreated()).andExpect(content().string("user added successfully"));

    }

    @Test
    void testUserControllerRoleNotFoundException() throws Exception {

        when(userService.addUser(TESTUSER, TESTPASSWORD)).thenThrow(RoleNotFoundException.class);
        this.mockMvc.perform(post("/signup").param(USERNAME, TESTUSER).param(PASSWORD, TESTPASSWORD)).andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("unable to assign a role to user"));

    }

    @Test
    void testUserControllerUnableToAddNewUserException() throws Exception {

        when(userService.addUser(TESTUSER, TESTPASSWORD)).thenThrow(UnableToAddNewUserException.class);
        this.mockMvc.perform(post("/signup").param(USERNAME, TESTUSER).param(PASSWORD, TESTPASSWORD)).andDo(print())
                .andExpect(status().isTemporaryRedirect())
                .andExpect(jsonPath("$.message").value("an unknown error occured while adding new user"));

    }

    @Test
    void testUserControllerUsernameExistsException() throws Exception {

        when(userService.addUser(TESTUSER, TESTPASSWORD)).thenThrow(UsernameExistsException.class);
        this.mockMvc.perform(post("/signup").param(USERNAME, TESTUSER).param(PASSWORD, TESTPASSWORD)).andDo(print())
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message").value("username already exists, create new one"));

    }

    @Test
    void testUserControllerValidation() throws Exception {

        this.mockMvc.perform(post("/signup").param(USERNAME, "test").param(PASSWORD, TESTPASSWORD)).andDo(print())
                .andExpect(status().isBadRequest());

    }

}
