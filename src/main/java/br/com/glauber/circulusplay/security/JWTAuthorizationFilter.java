package br.com.glauber.circulusplay.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
		
	private JWTUtil jwtUtil;
	private UserDetailsService userDetailsService;

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserDetailsService userDetailsService) {		
		super(authenticationManager);
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;		
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		super.doFilterInternal(request, response, chain);
		String header = request.getHeader("Authorization");
		
		if( header != null && header.startsWith("Bearer ")) {						
			UsernamePasswordAuthenticationToken auth = getAuthentication(header.substring(7));
			if (auth != null) {
				System.out.println(auth);
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}		
		chain.doFilter(request, response);		
	}

	private UsernamePasswordAuthenticationToken getAuthentication(String token) {

		if(jwtUtil.tokenValido(token)) {
			System.out.println("token é valido");
			String nomeUsuario = jwtUtil.getUsername(token);
			UserDetails usuario = userDetailsService.loadUserByUsername(nomeUsuario);
			System.out.println(usuario.getUsername());
			System.out.println(usuario.getAuthorities());
			System.out.println(usuario.getPassword());
			return new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
				
		}
		return null;
	}

}
