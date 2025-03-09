package br.com.transaction.management.controller;

import br.com.transaction.management.dto.StatisticResponse;
import br.com.transaction.management.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class StatisticController {

    private final TransactionService transactionService;

    public StatisticController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatisticResponse> getStatistics() {
        return ResponseEntity.ok(new StatisticResponse(transactionService.getStatistics()));
    }
}
