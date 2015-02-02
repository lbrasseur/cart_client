package com.globant.carrito.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.globant.carrito.StatusDto;

@RestController
public class SecurityService {
	private static final String USER_ID_KEY = "userId";

	@RequestMapping(value = "/service/login", method=RequestMethod.POST)
	@ResponseBody
	public StatusDto login(@RequestBody LoginDto dto, HttpServletRequest request) {
		boolean isValid = (dto.getUsername().equals("bart")
				&& dto.getPassword().equals("simpson"));

		if (isValid) {
			// Almacenando el username a modo de ejemplo.
			// Probablemente es mejor almacenar el ID, pero para
			// eso seria necesario hacer una consulta a la base.
			request.getSession().setAttribute(USER_ID_KEY, dto.getUsername());
		}

		return new StatusDto(isValid);
	}

	@RequestMapping(value = "/service/logout", method=RequestMethod.GET)
	@ResponseBody
	public StatusDto logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return new StatusDto(true);
	}
}
