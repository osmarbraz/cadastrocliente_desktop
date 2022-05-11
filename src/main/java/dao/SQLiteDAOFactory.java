package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import dao.cliente.ClienteDAO;
import dao.cliente.SQLiteClienteDAO;
import java.util.logging.Logger;

/**
 * Implementa a fonte de dado para persistência em arquivo utilizando SGBD
 * SQLite.
 *
 * @author osmarbraz
 */
public class SQLiteDAOFactory extends DAOFactory {

    private static final Logger LOGGER = Logger.getLogger(SQLiteDAOFactory.class.getName());

    private String driverClass;
    private String jdbcURL;

    /**
     * Construtor sem argumentos.
     */
    public SQLiteDAOFactory() {
        setDriverClass(SQLiteDadosBanco.DRIVER);
        setJdbcURL("jdbc:sqlite:" + SQLiteDadosBanco.DATABASE);
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getJdbcURL() {
        return jdbcURL;
    }

    public void setJdbcURL(String jdbcURL) {
        this.jdbcURL = jdbcURL;
    }

    /**
     * Retorna uma conexão aberta para as subclasses da fábrica para SQLite.
     *
     * @return Connection Um objeto com a conexão aberta
     * @exception SQLException
     */
    protected Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName(getDriverClass());
            con = DriverManager.getConnection(getJdbcURL());
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Classe não encontrada!");
        } catch (SQLException e) {
            LOGGER.severe("Problema na conexão!");
            throw e;
        }
        return con;
    }

    /**
     * Operação para prepara a string que será enviada ao banco de dados Se ela
     * possui uma ' será duplicada para anular o efeito de sql injetado
     *
     * @return String texto com ' duplicado
     * @param valor string a ser preparada para envio ao banco de dados
     */
    protected String preparaSQL(String valor) {
        if (valor != null) {
            return valor.replace("\'", "''");
        } else {
            return "";
        }
    }

    /**
     * Concatena String baseado nos valores Strings de uma Collection
     *
     * @return String Com os literais conctatenados.
     *
     * @param separator
     * @param collection
     */
    public String implode(String separator, @SuppressWarnings("rawtypes") Collection collection) {
        StringBuilder textBuilderReturn = new StringBuilder();
        @SuppressWarnings("rawtypes")
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String text = (String) it.next();
            textBuilderReturn.append(text);
            if (it.hasNext()) {
                textBuilderReturn.append(separator);
            }
        }
        return textBuilderReturn.toString();
    }

    /**
     * Retorna uma Cliente DAO
     *
     * @return ClienteDAO Um DAO para cliente
     */
    public ClienteDAO getClienteDAO() {
        return new SQLiteClienteDAO();
    }
}
