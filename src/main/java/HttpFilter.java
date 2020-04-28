import javax.servlet.*;
import java.io.IOException;


public class HttpFilter implements Filter {

  
private transient FilterConfig filterConfig;

@Override
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = filterConfig;
    }

@Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.getWriter().println();
        chain.doFilter(request, response);
        response.getWriter().println();
    }

@Override
    public void destroy() {

    }
}
