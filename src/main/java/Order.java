import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.io.Serializable;


public class Order implements Servlet, Serializable {

    private Logger logger = LoggerFactory.getLogger(Order.class);
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

        res.getWriter().println("<h1 align=\"center\" style=\"color:#0000ff; font-size:30px\">ЗАКАЗ ТОВАРА<h2 align=\"center\" >(КУПИТЬ ТОВАР)!!!</h2></h1>");
        req.getServletContext().getRequestDispatcher("/WEB-INF/order.jsp").forward(req,res);
    }

    @Override
    public String getServletInfo() {
        return "ЗАКАЗ...";
    }

    @Override
    public void destroy() {
        logger.info("Order class destroy");

    }

    public void setName(String newName) {
    }
}

