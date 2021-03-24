package jee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class MonServlet extends HttpServlet {

    private int init = 0;
    private int doget = 0;

    public MonServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        this.doget++;
        System.out.println("init : " + this.init);
        System.out.println("doget : " + this.doget);
        Cookie c = new Cookie("cookie", "moncookiedebeaugosse");
        c.setMaxAge(1);
        resp.addCookie(c);
        resp.getWriter().append("ENI - 22 mars 2021");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    public void init() throws ServletException {
        this.init++;

    }
}
