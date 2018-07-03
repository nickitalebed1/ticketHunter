package com.ticket.hunter.controller;

import com.ticket.hunter.client.TicketInfoRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/train")
public class TrainTicketController {

    @Autowired
    private TicketInfoRetriever ticketInfoRetriever;

    @RequestMapping("/dummy")
    public ResponseEntity<String> findTickets() {
        return ticketInfoRetriever.retrieveTrainTickets();
    }

}
