/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.didacusabella.mobilesolutions.client;

import com.didacusabella.mobilesolutions.entities.Client;
import java.sql.SQLException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author diego
 */
public class ClientManagerTest {
  
  private ClientManager manager;
  
  @Before
  public void setUp() throws SQLException {
    this.manager = ClientManager.getInstance();
  }

  /**
   * Test of getInstance method, of class ClientManager.
   */
  @Test
  public void testGetInstance() throws Exception {
    assertNotNull(this.manager);
  }

  /**
   * Test of mapRow method, of class ClientManager.
   */
  @Test
  public void testMapRow() throws Exception {
    
  }

  /**
   * Test of getClient method, of class ClientManager.
   */
  @Test
  public void testGetClient() {
    Client cl = this.manager.getClient(2);
    assertNotNull(cl);
    assertEquals("scemo", cl.getName());
  }

  /**
   * Test of getAllClients method, of class ClientManager.
   */
  @Test
  public void testGetAllClients() {
    List<Client> result = this.manager.getAllClients();
    assertEquals(2, result.size());
  }

  /**
   * Test of insertClient method, of class ClientManager.
   */
  @Test
  public void testInsertClient() {
     Client client = new Client("Diego", "Avella", "VLLDGI93A08C361G", "Via Starza 10", 
            "84013", "Cava de\' Tirreni", "SA", "089341367", "3315807943", "089348956", 
            "didacusabella", "delucia", "diego_avella@libero.it");
     assertTrue(this.manager.insertClient(client));
  }

  /**
   * Test of deleteClient method, of class ClientManager.
   */
  @Test
  public void testDeleteClient() {
    assertTrue(this.manager.deleteClient(9));
  }

  /**
   * Test of updateClient method, of class ClientManager.
   */
  @Test
  public void testUpdateClient() {
     Client client = new Client("Davide", "Avella", "VLLDGI93A08C361G", "Via Starza 10", 
            "84013", "Cava de\' Tirreni", "SA", "089341367", "3315807943", "089348956", 
            "didacusabella", "delucia", "diego_avella@libero.it");
     client.setId(9);
     assertTrue(this.manager.updateClient(client));
  }
  
}
