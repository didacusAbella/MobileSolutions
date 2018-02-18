package com.didacusabella.mobilesolutions.smartphone;


import com.didacusabella.mobilesolutions.entities.Smartphone;

import java.util.List;

/**
 * @author Domenico Antonio Tropeano on 15/02/2018 at 11:51
 * @project MobileSolutions
 */
public interface SmartphoneDAO {
    /**
     * Add Smartphone to database
     *
     * @param smartphone object
     * @return <code>true</code> if the smartphone is correctly added;
     * <code>false</code> otherwise
     */
    boolean addSmartphone(Smartphone smartphone);

    /**
     * Get all Smartphone in the database
     *
     * @return List<Smartphone>
     */
    List<Smartphone> getAllSmartphone();

    Smartphone getSmartphoneByID(int id);

    List<Smartphone> getSmartphoneOUT(int min);

    boolean deleteSmartphone(int id);

    boolean editSmartphone(Smartphone sm);

    boolean importXML(String pathToXML);

}
