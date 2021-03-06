import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.io.Serializable;

public class Main implements Servlet, Serializable {

    private Logger logger = LoggerFactory.getLogger(Main.class);
    private  transient ServletConfig config;


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
            logger.info("New request");

            res.getWriter().println("<h1 align=\"center\" style=\"color:#0000ff; font-size:30px\">Добро пожаловать на главную страницу!!!</h1>");
        req.getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(req,res);
    }

    @Override
    public String getServletInfo() {
        return "Что то...";
    }

    @Override
    public void destroy() {
        logger.info("Main class destroy");

    }
}
