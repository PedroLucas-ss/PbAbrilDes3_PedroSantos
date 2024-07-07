package org.pl.mscustomer;



import org.junit.jupiter.api.Test;
import org.pl.mscustomer.controller.CustomerController;
import org.pl.mscustomer.dto.CustomerDto;
import org.pl.mscustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CPFTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void whenInvalidCpf_thenReturns400() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCpf("12345678901"); // CPF inválido
        customerDto.setName("Test Name");
        customerDto.setEmail("test@example.com");
        customerDto.setUrlPhoto("http://example.com/photo.jpg");

        mockMvc.perform(post("/v1/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"cpf\": \"12345678901\", \"name\": \"Test Name\", \"email\": \"test@example.com\", \"urlPhoto\": \"http://example.com/photo.jpg\" }"))
                .andExpect(status().isBadRequest());
    }
}

