package com.coderbd.springbootjms.jms;


import com.coderbd.springbootjms.documents.OrderTransaction;
import com.coderbd.springbootjms.repositories.OrderTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderTransactionReceiver {

  @Autowired private OrderTransactionRepository transactionRepository;

  private int count = 1;

  @JmsListener(destination = "OrderTransactionQueue", containerFactory = "myFactory")
  public void receiveMessage(OrderTransaction transaction) {
    System.out.println("<" + count + "> Received <" + transaction + ">");
    count++;
    //    throw new RuntimeException();
    transactionRepository.save(transaction);
  }
}
