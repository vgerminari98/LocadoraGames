package DAO;

import Model.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*import java.util.HashSet;*/
public class ClienteDAO {

    public java.sql.Connection connection;

    public ClienteDAO() throws SQLException {
        this.connection = Conexao.getConnection();
    }

    public String inserir(Cliente cliente) {
        String sql
                = "insert into cliente(NOME, TELEFONE, IDADE, EMAIL) values (?,?,?,?)";
        try {
            PreparedStatement ps = Conexao.getConnection().
                    prepareStatement(sql);
            //seta os valores
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelefone());
            ps.setString(3, cliente.getIdade());
            ps.setString(4, cliente.getEmail());

            if (ps.executeUpdate() > 0) {//executa
                ps.close();
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

}
