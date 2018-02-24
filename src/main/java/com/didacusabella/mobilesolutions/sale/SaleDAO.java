package com.didacusabella.mobilesolutions.sale;

import com.didacusabella.mobilesolutions.entities.Sale;

import java.util.List;

/**
 * @author Domenico Antonio Tropeano on 15/02/2018 at 12:43
 * @project MobileSolutions
 * Database Access Object Pattern for Sale Table
 */
public interface SaleDAO {
  
    /**
     * Retrieve all payments for  specific client
     * @param clientID the id of the client
     * @return a list of sales
     */
    List<Sale> getAllSaleForClient(int clientID);
    
    /**
     * Buy a product and add a sale for a specific user
     * @param sl the sale to add
     * @return true if the Sale was addedd with success
     */
    boolean buyProduct(Sale sl);

}
