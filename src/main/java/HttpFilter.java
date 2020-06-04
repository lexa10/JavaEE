import javax.servlet.*;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HttpFilter implements Filter {

  
private transient FilterConfig filterConfig;

@Override
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @WebServlet("/AdminServlet")
    @ServletSecurity(@HttpConstraint(rolesAllowed = { "ADMIN" }))
    public class AdminServlet extends HttpServlet {

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            PrintWriter writer = resp.getWriter();
            writer.println("<h1>Admin servlet</h1>");
        }
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
