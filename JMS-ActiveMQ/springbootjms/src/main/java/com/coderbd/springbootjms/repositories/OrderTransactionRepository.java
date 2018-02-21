package com.coderbd.springbootjms.repositories;


import com.coderbd.springbootjms.documents.OrderTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderTransactionRepository extends MongoRepository<OrderTransaction, String> {}
