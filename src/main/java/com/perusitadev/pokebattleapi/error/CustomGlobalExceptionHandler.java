package com.perusitadev.pokebattleapi.error;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(PokemonNotFoundEx.class)
	public void springHandlerNotFound(HttpServletResponse res) throws IOException{
		res.sendError(HttpServletResponse.SC_NOT_FOUND);
	}
}
