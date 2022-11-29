package br.com.ijuda.api.controller;

import br.com.ijuda.api.IjudaApiApplication;
import br.com.ijuda.api.IjudaApiApplicationTests;
import br.com.ijuda.api.controller.dto.Paginator;
import br.com.ijuda.api.token.util.MvcResultUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;

@TestMethodOrder(MethodOrderer.MethodName.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = IjudaApiApplication.class )
@Sql({"/data/dataResetAll.sql", "/data/prestador_servico.sql"})
public class PrestadorServicoControllerTests extends IjudaApiApplicationTests {

    private static final String URI = "/usuario/1";
    private static final String URI_LOGIN = "/oauth/token";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private MvcResultUtil mvcUtil;

    @Test
    void teste00()throws Exception {
        MvcResult result = mvc.perform(
                        MockMvcRequestBuilders
                                .get(URI_LOGIN)
                                .header("username")
                                .accept(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }


    @Test
    void teste01()throws Exception {
        MvcResult result = mvc.perform(
                        MockMvcRequestBuilders
                                .get(URI)
                                .accept(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
        Paginator detalhamento = mvcUtil.converterResult(contentAsString, new TypeReference<Paginator>() {
        });

        Assertions.assertNotNull(detalhamento);
        Assertions.assertEquals(1L,detalhamento.getTotalElements());
    }

    @Test
    @DisplayName("filtro")
    void teste15() throws Exception {
        MvcResult result = mvc.perform(
                        MockMvcRequestBuilders
                                .get(URI)
                                .param("servicos", "1")
                                .param("categorias", "1")
                                .accept(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
        Paginator detalhamento = mvcUtil.converterResult(contentAsString, new TypeReference<Paginator>() {
        });

        Assertions.assertNotNull(detalhamento);
        Assertions.assertEquals(1L,detalhamento.getTotalElements());
    }


    @Test
    @DisplayName("Valida header authorization com token valido")
    void teste02() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders
                        .get(URI)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk());

    }
}