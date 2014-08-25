package filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ConversorMayusculasFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
		, urlPatterns = {
			"/ResultadoAmbito",
			"/HolaMundo",
			"/HolaMundoDD",
			"/AmbitoForm",
			"/Formulario"
		}
)
public class ConversorMayusculasFilter implements Filter {
	public void destroy() { }
	public void init(FilterConfig fConfig) throws ServletException { }
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Se ejecuta en la petición
		String nombre = request.getParameter("nombre");
		request.setAttribute("nombre", (nombre!=null)?nombre.toUpperCase():"");
		
		System.out.println("Acceso desde: " + request.getRemoteAddr() + 
				" a " + request.getServletContext().getContextPath());
		
		chain.doFilter(request, response);
		// Se ejecuta en la respuesta
	}
}
