package com.phase1ph.exam1;

import com.phase1ph.exam1.controller.DonationRestController;
import com.phase1ph.exam1.service.DonationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.phase1ph.exam1.model.Response.DONATE_SUCCESS_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DonationRestController.class)
public class Exam1ApplicationIT
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DonationService donationService;

    @Test
    public void testDonateRest_Normal() throws Exception {

        float testAmount = 10f;

        RequestBuilder request = MockMvcRequestBuilders
                .post("/donate")
                .accept(MediaType.ALL_VALUE)
                .param("amount", String.valueOf(testAmount))
                .contentType(MediaType.MULTIPART_FORM_DATA);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk()).andReturn();

        assertEquals(String.format(DONATE_SUCCESS_MESSAGE, String.valueOf(testAmount)), result.getResponse().getContentAsString());
    }
}