package kz.junior.task.controller;

import kz.junior.task.dto.TransactionDTO;
import kz.junior.task.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {
  private final TransactionService transactionService;

  @PostMapping
  public ResponseEntity<TransactionDTO> saveExpense(@RequestBody TransactionDTO transactionDTO){
    final TransactionDTO savedTransaction = transactionService.setTransaction(transactionDTO);
    return new ResponseEntity<TransactionDTO>(savedTransaction, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<TransactionDTO>> getAllExceededTransactions(){
    return new ResponseEntity<>(transactionService.getExceededTransactions(), HttpStatus.OK);
  }
}
