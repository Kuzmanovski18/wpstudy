package mk.finki.ukim.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.wp.lab.model.Event;
import mk.finki.ukim.wp.lab.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "EventListServlet", urlPatterns = "/servlet/eventlist")
public class EventListServlet extends HttpServlet {
    private final EventService eventService;
    private final SpringTemplateEngine springTemplateEngine;

    public EventListServlet(EventService eventService, SpringTemplateEngine springTemplateEngine) {
        this.eventService = eventService;
        this.springTemplateEngine = springTemplateEngine;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Event> eventList;
        String searchName = req.getParameter("searchName");
        String minRatingStr = req.getParameter("minRating");  // Avoid parsing directly


        if ((searchName != null && !searchName.isEmpty()) && (minRatingStr != null && !minRatingStr.isEmpty())) {
            double minRating = Double.parseDouble(minRatingStr);
            eventList = eventService.searchEvents(searchName).stream()
                    .filter(event -> event.getPopularityScore() >= minRating)
                    .toList();
        } else if (minRatingStr != null && !minRatingStr.isEmpty()) {
            double minRating = Double.parseDouble(minRatingStr);
            eventList = eventService.listAll().stream()
                    .filter(event -> event.getPopularityScore() >= minRating)
                    .toList();
        } else if (searchName != null && !searchName.isEmpty()) {
            eventList = eventService.searchEvents(searchName);
        } else {
            eventList = eventService.listAll();
        }


        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(iWebExchange);
        context.setVariable("events", eventList);


        this.springTemplateEngine.process("listEvents.html", context, resp.getWriter());
    }


}
