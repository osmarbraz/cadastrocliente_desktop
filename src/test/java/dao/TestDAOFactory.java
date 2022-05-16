package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestDAOFactory {

    @Test
    public void testgetDAOFactory1() {
        DAOFactory factory = DAOFactory.getDAOFactory(1);
        assertTrue(factory instanceof SQLiteDAOFactory);
    }

    @Test
    public void testgetDAOFactory2() {
        DAOFactory factory = DAOFactory.getDAOFactory(2);
        assertTrue(factory instanceof HashMapDAOFactory);
    }

    @Test
    public void testgetDAOFactory3() {
        DAOFactory factory = DAOFactory.getDAOFactory(3);
        assertTrue(factory instanceof RAFDAOFactory);
    }

    @Test
    public void testgetDAOFactoryNull() {
        DAOFactory factory = DAOFactory.getDAOFactory(4);
        assertEquals(null, factory);
    }
}
