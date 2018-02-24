package com.didacusabella.mobilesolutions.shipment;

import com.didacusabella.mobilesolutions.entities.Shipment;

import java.util.List;

/**
 * @author Domenico Antonio Tropeano on 15/02/2018 at 15:13
 * @project MobileSolutions
 * Database Access Object Pattern for Shipment Table
 */
public interface ShipmentDAO {
  
    /**
     * Add a new shipment to the system
     * @param shipment the new shipment
     * @return true if was addedd with success
     */
    boolean addShipment(Shipment shipment);

    /**
     * Retrieve a shipment by id
     * @param id the id of the shipment
     * @return a Shipment instance
     */
    Shipment getShipmentByID(int id);
    
    /**
     * Get all possible shipments
     * @return a list of shipments
     */
    List<Shipment> getAllShipment();
    
    /**
     * Update a specific shipment
     * @param shipment the shipment to update
     * @return true if the shipment was updated with success
     */
    boolean updateShipment(Shipment shipment);
    
    /**
     * Delete a shipment
     * @param id the id of the shipment
     * @return true if the shipment was removed with success
     */
    boolean deleteShipment(int id);
}
