package com.didacusabella.mobilesolutions.shipment;

import com.didacusabella.mobilesolutions.entities.Shipment;

import java.util.List;

/**
 * @author Domenico Antonio Tropeano on 15/02/2018 at 15:13
 * @project MobileSolutions
 */
public interface ShipmentDAO {
    boolean addShipment(Shipment shipment);

    Shipment getShipmentByID(int id);

    List<Shipment> getAllShipment();

    boolean updateShipment(Shipment shipment);

    boolean deleteShipment(int id);
}
