package com.didacusabella.mobilesolutions.client;

import com.didacusabella.mobilesolutions.customException.UsernameAlreadyExistException;
import com.didacusabella.mobilesolutions.entities.Client;

import java.util.List;

/**
 *
 * @author didacusAbella
 * Database Access Object Pattern for Client entity
 */
public interface ClientDao {
  /**
   * Get a single client by id
   * @param id the id of the client
   * @return a client reference associated with this id
   */
  Client getClient(int id);
  /**
   * Get all clients in table
   * @return a list of clients
   */
  List<Client> getAllClients();
  /**
   * Add a new client into the database
   * @param client the client to add
   * @return true if the insertion goes successfully
   * @throws com.didacusabella.mobilesolutions.customException.UsernameAlreadyExistException if the username already exist
   */
  boolean insertClient(Client client) throws UsernameAlreadyExistException;
  /**
   * Update a client's infomation
   * @param client the client to update
   * @return true if the update goes successfully
   */
  boolean updateClient(Client client);
  /**
   * Delete a client from the database
   * @param id the id of the client
   * @return true if the client was removed successfully
   */
  boolean deleteClient(int id);
  /**
   * Login a client into the system
   * @param username the username of the client
   * @param password the password of the client
   * @return true if the client was found into the database
   */
  boolean login(String username, String password);

  /**
   * Retrieve a client by username
   * @param username the username of the client
   * @return a Client instance if is registered in the system
   */
  Client getClient(String username);
}
