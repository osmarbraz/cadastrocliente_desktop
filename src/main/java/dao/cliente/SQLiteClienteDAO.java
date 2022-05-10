package dao.cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dao.SQLiteDAOFactory;
import entidade.Cliente;

/**
 * Implementa a persistência de cliente utilizando SQLite.
 *
 * @author osmarbraz
 */
public class SQLiteClienteDAO extends SQLiteDAOFactory implements ClienteDAO, SQLiteClienteMetaDados {

    @SuppressWarnings({"rawtypes", "unchecked"})
    private List select(String sql) {
        LinkedList lista = new LinkedList();
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
            rs.close();
            rs = null;
            stmt.close();
            stmt = null;
            con.close();
            con = null;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {;
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {;
                }
                stmt = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {;
                }
                con = null;
            }
        }
        return lista;
    }

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

                sql.append("values ('" + preparaSQL(cliente.getClienteId()));
                sql.append("','" + preparaSQL(cliente.getNome()));
                sql.append("','" + preparaSQL(cliente.getCpf()) + "')");

                con = getConnection();
                stmt = con.createStatement();
                res = stmt.executeUpdate(sql.toString()) > 0;
                stmt.close();
                stmt = null;
                con.close();
                con = null;

            } catch (SQLException e) {
                System.out.println(e);
                res = false;
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {;
                    }
                    stmt = null;
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {;
                    }
                    con = null;
                }
            }
            return res;
        }
        return false;
    }

    public int alterar(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            Connection con = null;
            Statement stmt = null;
            int res = 0;
            StringBuilder sql = new StringBuilder();
            try {
                sql.append("update " + TABLE);
                sql.append(" set NOME='" + cliente.getNome() + "',");
                sql.append(" CPF='" + cliente.getCpf() + "'");
                sql.append(" where " + TABLE + "." + PK[0] + "='" + preparaSQL(cliente.getClienteId()) + "'");

                con = getConnection();
                stmt = con.createStatement();
                res = stmt.executeUpdate(sql.toString());
                stmt.close();
                stmt = null;
                con.close();
                con = null;

            } catch (SQLException e) {
                System.out.println(e);
                res = 0;
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {;
                    }
                    stmt = null;
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {;
                    }
                    con = null;
                }
            }
            return res;
        }
        return 0;
    }

    public int excluir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            Connection con = null;
            Statement stmt = null;

            StringBuilder sql = new StringBuilder();
            int res = 0;
            try {
                sql.append("delete from " + TABLE + " where " + TABLE + "." + PK[0] + " = '" + preparaSQL(cliente.getClienteId()) + "'");
                con = getConnection();
                stmt = con.createStatement();
                res = stmt.executeUpdate(sql.toString());
                stmt.close();
                stmt = null;
                con.close();
                con = null;

            } catch (Exception e) {
                System.out.println(e);
                res = 0;
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {;
                    }
                    stmt = null;
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {;
                    }
                    con = null;
                }
            }
            return res;
        }
        return 0;
    }

    @SuppressWarnings("rawtypes")
    public List getLista() {
        return select("select " + METADADOSSELECT + " from " + TABLE + " order by " + TABLE + "." + PK[0]);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List aplicarFiltro(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;

            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("select " + METADADOSSELECT + " from " + TABLE);

            List filtros = new ArrayList();

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
                sqlBuilder.append(" where " + implode(" and ", filtros));
            }

            sqlBuilder.append(" order by " + TABLE + "." + PK[0]);

            return select(sqlBuilder.toString());
        } else {
            return null;
        }
    }

    public void criar() {
        Connection con = null;
        Statement stmt = null;
        try {
            con = getConnection();
            stmt = con.createStatement();
            //Cria a tabela sen�o existir
            stmt.execute("create table IF NOT EXISTS cliente (clienteId integer, nome varchar(100), cpf varchar(11), CONSTRAINT PK_Cliente PRIMARY KEY (clienteID));");
            stmt.close();
            stmt = null;
            con.close();
            con = null;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {;
                }
                stmt = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {;
                }
                con = null;
            }
        }
    }
}
