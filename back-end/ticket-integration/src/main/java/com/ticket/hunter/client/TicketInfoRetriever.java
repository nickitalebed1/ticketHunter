package com.ticket.hunter.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class TicketInfoRetriever {

    @Autowired
    private RestTemplate restTemplate;

    private String resourceUrl = "https://booking.uz.gov.ua/en/train_search/";

    public ResponseEntity<String> retrieveTrainTickets() {
        String from = "2204001";
        String to = "2218000";
        String date = "2018-08-03";
        String time = "00:00";
        String get_tpl = "1";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("from", from);
        params.add("to", to);
        params.add("date", date);
        params.add("time", time);
        params.add("get_tpl", get_tpl);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        return restTemplate.postForEntity(resourceUrl, request, String.class);
    }

}
