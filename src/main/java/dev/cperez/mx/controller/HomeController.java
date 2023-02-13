package dev.cperez.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.cperez.mx.dao.RequestDAO;

//import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
//@Api(value = "Controlador de preba")
public class HomeController {

	@Autowired
	private RequestDAO requestDAO;
	
	@GetMapping("/mensaje")
	public String mensaje() {
		//requestDAO.pruebaConeccion();
		requestDAO.getDuenio(1); 
		requestDAO.getColonia();
		return "Controlador Home"; 
	}

}
