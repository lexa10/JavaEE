import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public class FirstServlet implements Servlet, Serializable {


    private Logger logger = LoggerFactory.getLogger(FirstServlet.class);
    private  transient ServletConfig config;

    @Override
    public void init(ServletConfig config)  {
        this.config = config;

    }


    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws IOException {
        logger.info("New request");

        res.getWriter().println("<h1>Hello world from Servlet</h1>");

    }

    @Override
    public String getServletInfo() {
        return "Hello world Servlet";
    }

    @Override
    public void destroy() {
        logger.info("FirstServlet class destroy");


    }
}
