package mk.finki.ukim.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.wp.lab.service.EventBookingService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "EventBookingServlet", urlPatterns = "/eventBooking")

public class EventBookingServlet extends HttpServlet {

    private final EventBookingService eventBookingService;

    private final SpringTemplateEngine springTemplateEngine;

    public EventBookingServlet(EventBookingService eventBookingService, SpringTemplateEngine springTemplateEngine) {
        this.eventBookingService = eventBookingService;
        this.springTemplateEngine = springTemplateEngine;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eventName = req.getParameter("eventName");
        String numTickets = req.getParameter("numTickets");
        String attendeeName = req.getParameter("attendeeName");


        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(iWebExchange);

        context.setVariable("eventName", eventName);
        context.setVariable("numTickets", numTickets);
        context.setVariable("attendeeName", attendeeName);
        context.setVariable("clientIp", req.getRemoteAddr());

        springTemplateEngine.process("bookingConfirmation.html", context, resp.getWriter());
    }

}