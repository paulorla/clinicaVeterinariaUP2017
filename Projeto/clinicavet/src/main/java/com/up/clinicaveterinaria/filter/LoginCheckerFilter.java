package com.up.clinicaveterinaria.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.up.clinicaveterinaria.model.Funcionario;

public class LoginCheckerFilter extends AbstractFilter implements Filter {
	private static Set<String> allowedURIs;

	public void init(FilterConfig fConfig) throws ServletException {
		if(allowedURIs == null){
			allowedURIs = new HashSet<String>();
			allowedURIs.add(fConfig.getInitParameter("loginActionURI"));

			//colocamos nessa lista os recursos de acesso permitido
			//os recursos geralmente ficam dentro de WebContent/resources/
			//Exemplo: WebContent/resources/images/layout/logo.png
			//allowedURIs.add("/clinicavet/javax.faces.resource/layout/logo.png.xhtml");
			
			allowedURIs.add("/clinicavet/javax.faces.resource/watermark/watermark.css.xhtml");
			allowedURIs.add("/clinicavet/javax.faces.resource/watermark/watermark.js.xhtml");
			allowedURIs.add("/clinicavet/javax.faces.resource/logo.jpg.xhtml");
		}
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
				FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		if (session.isNew()) {
			doLogin(request, response, req);
			return;
		}
		Funcionario func = (Funcionario) session.getAttribute("user");

		if (func == null && !allowedURIs.contains(req.getRequestURI())) {
			doLogin(request, response, req);
			return;
		}
		chain.doFilter(request, response);
	}
}
