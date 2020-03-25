package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.connection.factory.ConnectionFactory;
import br.com.model.Jogo;

public class JogoDao {

    public List<Jogo> listar() {

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        ConnectionFactory connectionFactory = new ConnectionFactory();
        List<Jogo> jogos = new ArrayList<Jogo>();

        try {
            con = connectionFactory.getConnection();
            ps = con.prepareStatement("select * from jogos");
            rs = ps.executeQuery();

            while (rs.next()) {
                Jogo jogo = new Jogo();
                jogo.setId(rs.getInt("id"));
                jogo.setNome(rs.getString("nome"));
                jogo.setPlataforma(rs.getString("plataforma"));
                jogos.add(jogo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            connectionFactory.closeConnection(rs, ps, con);
        }
        return jogos;
    }

    public void deletar(Integer id) {

        Connection con = null;
        PreparedStatement ps = null;
        ConnectionFactory connectionFactory = new ConnectionFactory();

        try {
            con = connectionFactory.getConnection();
            ps = con.prepareStatement("delete from jogos where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionFactory.closeConnection(null, ps, con);
        }

    }

    public void salvar(Jogo jogo) {

        Connection con = null;
        PreparedStatement ps = null;
        ConnectionFactory connectionFactory = new ConnectionFactory();

        try {

            con = connectionFactory.getConnection();
            ps = con.prepareStatement("insert into jogos values (SEQ_JOGOS.nextval,?,?)");
            ps.setString(1, jogo.getNome());
            ps.setString(2, jogo.getPlataforma());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            connectionFactory.closeConnection(null, ps, con);
        }
    }

    public Jogo findById(Integer id) {

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        ConnectionFactory connectionFactory = new ConnectionFactory();

        try {

            con = connectionFactory.getConnection();
            ps = con.prepareStatement("select id,nome,plataforma from jogos where id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Jogo jogo = new Jogo();
                jogo.setId(rs.getInt("id"));
                jogo.setNome(rs.getString("nome"));
                jogo.setPlataforma(rs.getString("plataforma"));
                return jogo;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            connectionFactory.closeConnection(rs, ps, con);
        }
        return null;
    }

    public void editar(Jogo jogo) {

        Connection con = null;
        PreparedStatement ps = null;
        ConnectionFactory connectionFactory = new ConnectionFactory();

        try {

            con = connectionFactory.getConnection();
            ps = con.prepareStatement("update jogos set nome = ?, plataforma = ? where id = ?");
            ps.setString(1, jogo.getNome());
            ps.setString(2, jogo.getPlataforma());
            ps.setInt(3, jogo.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            connectionFactory.closeConnection(null, ps, con);
        }

    }

}