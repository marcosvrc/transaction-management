package br.com.transaction.management.controller;

import br.com.transaction.management.dto.TransactionRequest;
import br.com.transaction.management.model.Transaction;
import br.com.transaction.management.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest transactionRequest) {
        if (transactionRequest.getDataHora().isAfter(OffsetDateTime.now()) || transactionRequest.getValor() < 0) {
            return ResponseEntity.unprocessableEntity().build();
        }
        transactionService.addTransaction(transactionReqestToTransaction(transactionRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private Transaction transactionReqestToTransaction(TransactionRequest transactionRequest) {
        return new Transaction(transactionRequest.getValor(), transactionRequest.getDataHora());
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTransactions() {
        transactionService.deleteAllTransactions();
        return ResponseEntity.ok().build();
    }


}