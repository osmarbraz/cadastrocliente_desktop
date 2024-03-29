package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TestSQLiteDAOFactory {

    /**
     * Testa se o driver não existe.
     */
    @Test
    public void testGetConnectionDriver() {
        SQLiteDAOFactory sqlitedaofactory = new SQLiteDAOFactory();
        sqlitedaofactory.setDriverClass("X");
        sqlitedaofactory.setJdbcURL("jdbc:sqlite:cliente.db");
        assertNull(sqlitedaofactory.getConnection());
    }

    /**
     * Testa se a url não existe.
     */
    @Test
    public void testGetConnectionURL() {
        SQLiteDAOFactory sqlitedaofactory = new SQLiteDAOFactory();
        sqlitedaofactory.setDriverClass("org.sqlite.JDBC");
        sqlitedaofactory.setJdbcURL("Y");
        assertNull(sqlitedaofactory.getConnection());
    }

    /**
     * Testa se o preparaSQL não existe.
     */
    @Test
    public void testPrepareSQL() {
        SQLiteDAOFactory sqlitedaofactory = new SQLiteDAOFactory();
        String prepara = sqlitedaofactory.preparaSQL(null);
        assertEquals("",prepara);
    }
}
