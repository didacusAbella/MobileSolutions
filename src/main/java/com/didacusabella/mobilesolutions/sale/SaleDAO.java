package com.didacusabella.mobilesolutions.sale;

import com.didacusabella.mobilesolutions.entities.Sale;

import java.util.List;

/**
 * @author Domenico Antonio Tropeano on 15/02/2018 at 12:43
 * @project MobileSolutions
 */
public interface SaleDAO {
    List<Sale> GetAllSaleForClient(int clientID);

    boolean BuyProduct(Sale sl);

}
