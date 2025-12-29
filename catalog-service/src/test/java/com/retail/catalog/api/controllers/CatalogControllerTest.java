
package com.retail.catalog.api.controllers;

import com.retail.catalog.api.controllers.impl.CatalogControllerImpl;
import com.retail.catalog.application.model.Product;
import com.retail.catalog.application.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.time.OffsetDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = CatalogControllerImpl.class)
class CatalogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productAppService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAll_returnsProducts() throws Exception {
        var products = List.of(new com.retail.catalog.infrastructure.entity.ProductEntity(1, "p1", 10.0, "testProduct","TestDescription", 2, OffsetDateTime.now()));
        var productDTOs = List.of(new Product(1, "p1", "testProduct",10.0, "imageUrl", 2, OffsetDateTime.now()));
        when(productAppService.getAll()).thenReturn(productDTOs);

        mockMvc.perform(get("/api/catalog/products"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(productDTOs)));
    }
}
