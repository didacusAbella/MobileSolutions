package com.didacusabella.mobilesolutions.managers;

import com.didacusabella.mobilesolutions.customException.UsernameAlreadyExistException;
import com.didacusabella.mobilesolutions.client.ClientManager;
import com.didacusabella.mobilesolutions.entities.Client;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * @author diego & Domenico Antonio Tropeano
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ClientManagerTest {

    private ClientManager manager;

    @Before
    public void test1setUp() throws SQLException {
        this.manager = ClientManager.getInstance();
    }

    /**
     * Test of getInstance method, of class ClientManager.
     */
    @Test
    public void test2GetInstance() {
        assertNotNull(this.manager);
    }

    /**
     * Test of mapRow method, of class ClientManager.
     */
    @Test
    public void test3MapRow() {
        Client client = manager.getClient("oromis");
        assertEquals(client.getId(), 1);
    }

    /**
     * Test of insertClient method, of class ClientManager.
     */
    @Test
    public void test4InsertClient() throws UsernameAlreadyExistException {
        Client client = new Client("Diego", "Avella", "VLLDGI93A08C361G", "Via Starza 10",
                "84013", "Cava de\' Tirreni", "SA", "089341367", "3315807943", "089348956",
                "didacusabella", "delucia", "diego_avella@libero.it");
        manager.insertClient(client);
        assertEquals(manager.getClient("didacusabella").getName(), "Diego");
    }

    /**
     * Test of getClient method, of class ClientManager.
     */
    @Test
    public void test5GetClient() {
        Client cl = this.manager.getClient(2);
        assertEquals("Mario", cl.getName());
    }

    /**
     * Test of getAllClients method, of class ClientManager.
     */
    @Test
    public void test6GetAllClients() {
        List<Client> result = this.manager.getAllClients();
        assertEquals(2, result.size());
    }


    /**
     * Test of deleteClient method, of class ClientManager.
     */
    @Test
    public void test8DeleteClient() {
        manager.deleteClient(9);
        assertEquals(manager.getClient(9), null);
    }

    /**
     * Test of updateClient method, of class ClientManager.
     */
    @Test
    public void test7UpdateClient() {
        Client client = new Client("Davide", "Avellaaa", "VLLDGI93A08C361G", "Via Starza 10",
                "84013", "Cava de\' Tirreni", "SA", "089341367", "3315807943", "089348956",
                "didacusabella", "delucia", "diego_avella@libero.it");
        client.setId(9);
        assertEquals(manager.getClient(9).getLastName(), "Avellaaa");
    }

}
