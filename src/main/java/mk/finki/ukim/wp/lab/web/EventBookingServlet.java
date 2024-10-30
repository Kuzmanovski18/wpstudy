package mk.finki.ukim.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.wp.lab.service.impl.EventServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "EventBookingServlet",urlPatterns = "/eventBooking")

public class EventBookingServlet extends HttpServlet {

    private final EventServiceImpl eventService;

    private final SpringTemplateEngine springTemplateEngine;

    public EventBookingServlet(EventServiceImpl eventService, SpringTemplateEngine springTemplateEngine){
        this.eventService = eventService;
        this.springTemplateEngine = springTemplateEngine;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eventName = req.getParameter("eventName");
        String numTickets = req.getParameter("numTickets");

        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req,resp);
        WebContext context = new WebContext(iWebExchange);
        context.setVariable("eventName",eventName);
        context.setVariable("numTickets",numTickets);
        springTemplateEngine.process("bookingConfirmation.html",context,resp.getWriter());
    }
}
