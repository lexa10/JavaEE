import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.io.Serializable;



public class Cart  implements Servlet, Serializable {

    private Logger logger = LoggerFactory.getLogger(Cart.class);
    private transient ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }


    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("New request");

        res.getWriter().println("<h1 align=\"center\" style=\"color:#0000ff; font-size:30px\">КОРЗИНА<h2 align=\"center\" >(В КОРЗИНЕ НЕТ ТОВАРОВ)!!!</h2></h1>");
        req.getServletContext().getRequestDispatcher("/WEB-INF/cart.jsp").forward(req,res);

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
