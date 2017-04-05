package com.mkaminski.hermes.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mkaminski.hermes.configuration.SpringConfiguration;
import com.mkaminski.hermes.dao.CourierDao;
import com.mkaminski.hermes.model.Courier;
import com.mkaminski.hermes.service.CourierServiceImpl;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes=SpringConfiguration.class)
public class CourierDaoAndControllerTest {

	@Autowired
	private WebApplicationContext context;

	@Mock
	private CourierDao courierDao;

	@InjectMocks
	private CourierServiceImpl courierServiceImpl;

	private MockMvc mockMvc;

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
		List<Courier> list = Arrays.asList(new Courier("Elvis", "Presley", "mail1@gmail.com", "1111"),
				new Courier("Antoni", "Macierewicz", "mail2@gmail.com", "2222"));
		when(courierDao.findAll()).thenReturn(list);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void mockServiceTest() {
		int count = courierServiceImpl.findAll().size();
		assertEquals(2, count);
	}
	
	@Test
	public void mockControllerTest() throws Exception {
		mockMvc.perform(get("/couriers")).andExpect(status().isOk());
	}
	
}
