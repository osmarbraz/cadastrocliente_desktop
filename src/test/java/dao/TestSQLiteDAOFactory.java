package dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestSQLiteDAOFactory {

    /**
     * Testa se o preparaSQL não existe.
     *
     */
    @Test
    public void testGetConnection() {
        SQLiteDAOFactory sqlitedaofactory = new SQLiteDAOFactory();
        sqlitedaofactory.setDriverClass("X");
        sqlitedaofactory.setJdbcURL("Y");
        assertNull(sqlitedaofactory.getConnection());
    }

    /**
     * Testa se o preparaSQL não existe.
     *
     */
    @Test
    public void testPrepareSQL() {
        SQLiteDAOFactory sqlitedaofactory = new SQLiteDAOFactory();
        String prepara = sqlitedaofactory.preparaSQL(null);
        assertTrue(prepara.equals(""));
    }
}
