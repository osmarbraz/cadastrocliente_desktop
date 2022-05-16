package util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestValida {

    private Valida valida = null;

    @Before
    public void inicializa() {
        valida = new Valida();
    }

    @After
    public void finaliza() {
        valida = null;
    }

    @Test
    public void testValidaCPFValido1() {
        assertTrue(valida.validaCPF("11111111111"));
    }

    @Test
    public void testValidaCPFValido2() {
        assertTrue(valida.validaCPF("84807125206"));
    }

    @Test
    public void testValidaCPFValido3() {
        assertTrue(valida.validaCPF("63883136395"));
    }

    @Test
    public void testValidaCPFValido4() {
        assertTrue(valida.validaCPF("31626333033"));
    }

    @Test
    public void testValidaCPFInvalido() {
        //CPF com problema na conversão
        assertFalse(valida.validaCPF("0065XAB22050"));
    }
}
