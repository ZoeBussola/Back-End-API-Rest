package com.proyecto.BussolaZoe;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.BussolaZoe.model.Domicilio;
import com.proyecto.BussolaZoe.model.Paciente;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class PacienteIntegracionTests {

	@Autowired
	private MockMvc mockMvc;

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void registrarPaciente() throws Exception {
		Paciente paciente = new Paciente();
		Domicilio domicilio= new Domicilio();
		domicilio.setCalle("Calle");
		domicilio.setNumero("66666");
		domicilio.setLocalidad("barrio");
		domicilio.setProvincia("provincia");
		paciente.setNombre("juan");
		paciente.setApellido("peres");
		paciente.setDNI(35418);
		paciente.setDomicilio(domicilio);

		MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/pacientes/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(paciente)))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void listarPacientes() throws Exception {
		MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/pacientes/")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());

	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void borrarPaciente() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/pacientes/1")).andExpect(MockMvcResultMatchers
				.status().is2xxSuccessful());
	}


}

