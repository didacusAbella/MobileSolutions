
package com.didacusabella.mobilesolutions.database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diego
 * Interface for map an object to table row
 * @param <T> generic entity to map
 */
public interface Mappable<T> {
  
  /**
   * Map a result set with a specific object
   * @param rs the result set
   * @return a custom mapped object
   * @throws SQLException if an error occurred
   */
  T mapRow(ResultSet rs) throws SQLException;
  
}
