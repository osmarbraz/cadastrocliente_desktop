package dao;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestSQLiteDAOFactory {
   
    /**
     * Testa se o preparaSQL não existe.
     *
     */
    @Test
    public void testAbrirArquivo() {
        SQLiteDAOFactory sqlitedaofactory = new SQLiteDAOFactory();
        String prepara = sqlitedaofactory.preparaSQL(null);
        assertTrue(prepara.equals(""));
    }
}