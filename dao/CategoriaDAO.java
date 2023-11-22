package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Categoria;

public class CategoriaDAO {
    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public void createCategoria(Categoria categoria) {
    	try {
            String sql = "INSERT INTO Categoria VALUES (DEFAULT, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, categoria.getNome());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        categoria.set_id_categoria(rst.getInt(1));
                    }
                }
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    };
    public Categoria retrieveCategoria(String nome_categoria) {
    	try {
            String sql = "SELECT * FROM Categoria WHERE nome_cat = ?";

            Categoria categoria1 = null;

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, nome_categoria);
                pstm.execute();

                ResultSet result = pstm.getResultSet();

                while(result.next()) {
                	int id = result.getInt("id_categoria");
                	String nome = result.getString("nome_cat");
                	
                	categoria1 = new Categoria(id, nome);
                }
            }
            return categoria1;

        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
    };
    
    public ArrayList<Categoria> retrieveAllCategorias() {
    	
    	ArrayList<Categoria> categorias = new ArrayList<Categoria>();

        try {
            String sql = "SELECT * FROM Categoria";

            try(PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                ResultSet result = pstm.getResultSet();

                while (result.next()) {
                    int id = result.getInt("id_categoria");
                    String nome = result.getString("nome_cat");
                    
                    Categoria categoria = new Categoria(id, nome);
                    categorias.add(categoria);
                }

            }

            return categorias;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    	
    };
    public void deleteCategoria(Categoria categoria) {
        try {
            String sql = "DELETE FROM Categoria WHERE id_categoria = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, categoria.get_id_categoria());
                pstm.execute();
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
    };
    public void updateCategoria(Categoria categoria) {
        try {
            String sql = "UPDATE Categoria SET nome_cat = ? WHERE id_categoria = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, categoria.getNome());
                pstm.setInt(2, categoria.get_id_categoria());
                pstm.execute();
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
    };
}
