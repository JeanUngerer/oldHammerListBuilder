package com.oldhammer.fantasylistbuilder.controllerTests;

import com.oldhammer.fantasylistbuilder.DTOs.AllBooksDTO;
import com.oldhammer.fantasylistbuilder.constants.Provider;
import com.oldhammer.fantasylistbuilder.entities.AllBooksEntity;
import com.oldhammer.fantasylistbuilder.entities.UserEntity;
import com.oldhammer.fantasylistbuilder.mappers.UserMapper;
import com.oldhammer.fantasylistbuilder.repositories.AllBooksRepository;
import com.oldhammer.fantasylistbuilder.repositories.UserRepository;
import com.oldhammer.fantasylistbuilder.services.AllBooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static com.oldhammer.fantasylistbuilder.utils.ObjectAsJsonStrings.asJsonString;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc(addFilters = true)
public class AllBooksControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private AllBooksService allBooksService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AllBooksRepository allBooksRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserMapper userMapper;



    private List<UserEntity> setupUsers() {
        UserEntity sender = userRepository.save(new UserEntity(1l, Provider.LOCAL, "mail1@mail.com", "user1", "user1",passwordEncoder.encode("pass1"), "firsteName1",
                "lastName1", "0101010101", "ROLE_ADMIN", new ArrayList<>()));
        List<UserEntity> userList = new ArrayList<UserEntity>();
        userList.add(sender);

        return userList;
    }

    @Test
    public void getAllBookssAPI() throws Exception {

        List<UserEntity> userList = setupUsers();

        UserEntity sender = userList.get(0);

        allBooksService.createAllBooks(new AllBooksDTO(null, "nameAll", "versionAll", "pathAll"));

        String token = obtainAccessToken(sender.getUserName(), "pass1");


        mockMvc.perform(get("/allBooks/allBookss")
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content()
                        .contentType("application/json"))
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andExpect(jsonPath("$[0].version").isNotEmpty());
    }

    @Test
    public void getAllBooksByIdAPI() throws Exception {

        List<UserEntity> userList = setupUsers();

        UserEntity sender = userList.get(0);

        AllBooksEntity allBooks = new AllBooksEntity(null, "nameById", "versionById", "pathById");

        AllBooksEntity saved =  allBooksRepository.save(allBooks);

        String token = obtainAccessToken(sender.getUserName(), "pass1");

        mockMvc.perform(get("/allBooks/{id}", saved.getId())
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content()
                        .contentType("application/json"))
                .andExpect(jsonPath("$.id").value(saved.getId()))
                .andExpect(jsonPath("$.name").value("nameById"))
                .andExpect(jsonPath("$.version").value("versionById"));
    }

    @Test
    public void createAPI() throws Exception {

        List<UserEntity> userList = setupUsers();

        UserEntity sender = userList.get(0);

        AllBooksDTO allBooksDTO = new AllBooksDTO(null, "nameCreate", "versionCreate", "pathCreate");

        String token = obtainAccessToken(sender.getUserName(), "pass1");

        mockMvc.perform(put("/allBooks/create")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(allBooksDTO)))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content()
                        .contentType("application/json"))
                .andExpect(jsonPath("$.name").value("nameCreate"))
                .andExpect(jsonPath("$.version").value("versionCreate"));
    }

    @Test
    public void updateAPI() throws Exception {

        List<UserEntity> userList = setupUsers();

        UserEntity sender = userList.get(0);

        AllBooksEntity allBooks = new AllBooksEntity(null, "name37", "version37", "path37");
        AllBooksEntity saved =  allBooksRepository.save(allBooks);

        AllBooksDTO allBooksDTO = new AllBooksDTO(saved.getId(), "name37-2", "version37-2", "path37-2");

        String token = obtainAccessToken(sender.getUserName(), "pass1");

        mockMvc.perform(post("/allBooks/update")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(allBooksDTO)))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content()
                        .contentType("application/json"))
                .andExpect(jsonPath("$.id").value(saved.getId()))
                .andExpect(jsonPath("$.name").value("name37-2"))
                .andExpect(jsonPath("$.version").value("version37-2"));
    }

    @Test
    public void deleteAPI() throws Exception {

        List<UserEntity> userList = setupUsers();

        UserEntity sender = userList.get(0);

        AllBooksEntity allBooks = new AllBooksEntity(null, "nameDel", "versionDel", "pathDel");

        AllBooksEntity saved =  allBooksRepository.save(allBooks);

        String token = obtainAccessToken(sender.getUserName(), "pass1");

        mockMvc.perform(delete("/allBooks/{id}", saved.getId())
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("AllBooks deleted")));

    }


    public String obtainAccessToken(String username, String password) throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", "userName");
        params.add("username", username);
        params.add("password", password);

        ResultActions result
                = mockMvc.perform(post("/token")
                        .params(params)
                        .with(httpBasic(username,password)))
                .andExpect(status().isOk());

        return result.andReturn().getResponse().getHeader("Token");
    }


}
