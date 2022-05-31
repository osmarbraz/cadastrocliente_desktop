package dao.cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.logging.Logger;
import java.util.logging.Level;

import dao.SQLiteDAOFactory;
import entidade.Cliente;

/**
 * Implementa a persistência de cliente utilizando SQLite.
 *
 * @author osmarbraz
 */
public class SQLiteClienteDAO extends SQLiteDAOFactory implements ClienteDAO, SQLiteClienteMetaDados {

    private static final Logger LOGGER = Logger.getLogger(SQLiteClienteDAO.class.getName());
    private static final String WHERE = " where ";

    public SQLiteClienteDAO() {
        criar();
    }

    public void fecharAcessoBD(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) { 
                LOGGER.log(Level.SEVERE, "Erro no fechamento do rs:{0}", e.toString());
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Erro no fechamento do stmt:{0}", e.toString());
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Erro no fechamento do con:{0}", e.toString());
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private List<Cliente> select(String sql) {
        List<Cliente> lista = new LinkedList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {

            con = getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setClienteId(rs.getString("CLIENTEID"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(rs.getString("CPF"));
                lista.add(cliente);
            }
           fecharAcessoBD(con, stmt, rs);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro no select:{0}", e.toString());
        } finally {
            fecharAcessoBD(con, stmt, rs);
        }
        return lista;
    }

    @Override
    public boolean inserir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            Connection con = null;
            Statement stmt = null;
            boolean res = false;
            StringBuilder sql = new StringBuilder();
            try {
                sql.append("insert into " + TABLE + "(");
                sql.append(METADADOSINSERT + " ) ");

                sql.append("values ('").append(preparaSQL(cliente.getClienteId()));
                sql.append("','").append(preparaSQL(cliente.getNome()));
                sql.append("','").append(preparaSQL(cliente.getCpf())).append("')");

                con = getConnection();
                stmt = con.createStatement();
                res = stmt.executeUpdate(sql.toString()) > 0;
                                
                fecharAcessoBD(con, stmt, null);

            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Erro no inserir:{0}", e.toString());
            } finally {
                fecharAcessoBD(con, stmt, null);
            }
            return res;
        }
        return false;
    }

    @Override
    public int alterar(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            Connection con = null;
            Statement stmt = null;
            int res = 0;
            StringBuilder sql = new StringBuilder();
            try {
                sql.append("update " + TABLE);
                sql.append(" set NOME='").append(cliente.getNome()).append("',");
                sql.append(" CPF='").append(cliente.getCpf()).append("'");
                sql.append(WHERE + TABLE + ".").append(PK[0]).append("='").append(preparaSQL(cliente.getClienteId())).append("'");

                con = getConnection();
                stmt = con.createStatement();
                res = stmt.executeUpdate(sql.toString());
               
                fecharAcessoBD(con, stmt, null);

            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Erro no alterar:{0}", e.toString());
                res = 0;
            } finally {
                fecharAcessoBD(con, stmt, null);
            }
            return res;
        }
        return 0;
    }

    @Override
    public int excluir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            Connection con = null;
            Statement stmt = null;
            StringBuilder sql = new StringBuilder();
            int res = 0;
            try {
                sql.append("delete from " + TABLE + WHERE + TABLE + ".").append(PK[0]).append(" = '").append(preparaSQL(cliente.getClienteId())).append("'");
                con = getConnection();
                stmt = con.createStatement();
                res = stmt.executeUpdate(sql.toString());
                
                fecharAcessoBD(con, stmt, null);

            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Erro no excluir:{0}", e.toString());
                res = 0;
            } finally {
                fecharAcessoBD(con, stmt, null);
            }
            return res;
        }
        return 0;
    }

    @Override
    public List<Cliente> getLista() {
        return select("select " + METADADOSSELECT + " from " + TABLE + " order by " + TABLE + "." + PK[0]);
    }

    @Override
    public List<Cliente> aplicarFiltro(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;

            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("select " + METADADOSSELECT + " from " + TABLE);

            List<String> filtros = new ArrayList<>();

            if (cliente.getClienteId() != null && !"".equals(cliente.getClienteId())) {
                filtros.add(TABLE + "." + PK[0] + "='" + preparaSQL(cliente.getClienteId()) + "'");
            }

            if (cliente.getNome() != null && !"".equals(cliente.getNome())) {
                filtros.add(TABLE + ".NOME like upper('%" + preparaSQL(cliente.getNome()) + "%')");
            }

            if (cliente.getCpf() != null && !"".equals(cliente.getCpf())) {
                filtros.add(TABLE + ".CPF = '" + preparaSQL(cliente.getCpf()) + "'");
            }

            if (!filtros.isEmpty()) {
                sqlBuilder.append(WHERE).append(implode(" and ", filtros));
            }

            sqlBuilder.append(" order by " + TABLE + ".").append(PK[0]);

            return select(sqlBuilder.toString());
        } else {
            return Collections.emptyList();
        }
    }

    private void criar() {
        Connection con = null;
        Statement stmt = null;
        try {
            con = getConnection();
            stmt = con.createStatement();
            //Cria a tabela senão existir
            stmt.execute("create table IF NOT EXISTS cliente (clienteId integer, nome varchar(100), cpf varchar(11), CONSTRAINT PK_Cliente PRIMARY KEY (clienteID));");
          
            fecharAcessoBD(con, stmt, null);
            
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro no criar:{0}", e.toString());
        } finally {
            fecharAcessoBD(con, stmt, null);
        }
    }
}
