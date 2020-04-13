import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.io.Serializable;

    public class Catalog implements Servlet, Serializable {

        private Logger logger = LoggerFactory.getLogger(Catalog.class);
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

            res.getWriter().println("<h1 align=\"center\" style=\"color:#0000ff; font-size:30px\">ТОВАРЫ<h2 align=\"center\" >(ШИРОКИЙ АССОРТИМЕНТ)!!!</h2></h1>");
            req.getServletContext().getRequestDispatcher("/WEB-INF/catalog.jsp").forward(req,res);
        }

        @Override
        public String getServletInfo() {
            return "Выбор широк...";
        }

        @Override
        public void destroy() {
            logger.info("Catalog class destroy");

        }
    }
