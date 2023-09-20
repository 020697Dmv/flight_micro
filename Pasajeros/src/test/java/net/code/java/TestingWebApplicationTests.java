package net.code.java;

import com.crud.vuelo.controller.ClienteController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ClienteController.class)
public class TestingWebApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllEmployeesAPI() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders
                .get("/clientes")
                .accept(MediaType.APPLICATION_JSON));
    }

}