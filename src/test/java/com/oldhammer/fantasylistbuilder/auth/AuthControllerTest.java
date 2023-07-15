package com.oldhammer.fantasylistbuilder.auth;

import com.oldhammer.fantasylistbuilder.constants.Provider;
import com.oldhammer.fantasylistbuilder.entities.UserEntity;
import com.oldhammer.fantasylistbuilder.repositories.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc(addFilters = true)
public class AuthControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @BeforeAll
    public static void prepareDB(){

    }

    @Test
    void rootWhenUnauthenticatedThen401() throws Exception {
        this.mockMvc.perform(get("/user"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void rootWhenAuthenticatedThenSaysHelloUser() throws Exception {


        UserEntity sender = userRepository.save(new UserEntity(101l, Provider.LOCAL, "mail101@mail.com", "user101", "user101",passwordEncoder.encode("pass101"), "firsteName101",
                "lastName101", "0101010101", "ROLE_USER", new ArrayList<>()));

        MvcResult result = this.mockMvc.perform(post("/token")
                        .with(httpBasic(sender.getUserName(), "pass101")))
                .andExpect(status().isOk())
                .andReturn();

        String token = result.getResponse().getHeader("Token");

        this.mockMvc.perform(get("/user")
                        .header("Authorization", "Bearer " + token))
                    .andDo(print())
                    .andExpect(status().isOk()).andExpect(content()
                            .contentType("application/json"))
                    .andExpect(jsonPath("$.message").value("Hi user101"));
    }

    @Test
    @WithMockUser
    public void rootWithMockUserStatusIsOK() throws Exception {
        this.mockMvc.perform(get("/home")).andExpect(status().isOk());
    }

}
