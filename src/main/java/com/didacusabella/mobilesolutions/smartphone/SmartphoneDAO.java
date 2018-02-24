package com.didacusabella.mobilesolutions.smartphone;


import com.didacusabella.mobilesolutions.entities.Smartphone;

import java.util.List;
import java.util.Map;

/**
 * @author Domenico Antonio Tropeano on 15/02/2018 at 11:51
 * @project MobileSolutions
 * Database Access Object Patten for Smartphone Table
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
     * @return List<Smartphone> a list of smartphones
     */
    List<Smartphone> getAllSmartphone();

    /**
     * Retrieve a smartphone by id
     * @param id the id of the smartphone
     * @return a smartphone instance
     */
    Smartphone getSmartphoneByID(int id);

    /**
     * Retrieve all smartphone that are finishing
     * @param min the min quantity
     * @return a list of smartphones
     */
    List<Smartphone> getSmartphoneOUT(int min);

    /**
     * Delete a smartphone from the database
     * @param id the id of the smartphone
     * @return true if was removed wth success
     */
    boolean deleteSmartphone(int id);

    /**
     * Update smartphone details
     * @param sm the updated smartphone
     * @return true if the update goes with success
     */
    boolean editSmartphone(Smartphone sm);
    
    /**
     * Search a smartphone by brand
     * @param brand the brand of the smartphone
     * @return a list of smartphones by brand
     */
    List<Smartphone> search(String brand);
    
    /**
     * Advanced search smartphones based on various criterias
     * @param criterias the list of criterias to search
     * @return a list of smartphones that match all criterias
     */
    List<Smartphone> advancedSearch(Map<String, String[]> criterias);

    /**
     * Import a dataser using an XML
     * @param pathToXML the path to file
     * @return true if the import goes with success
     */
    boolean importXML(String pathToXML);

}
