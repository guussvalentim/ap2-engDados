package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Autor;
import modelo.Musica;

public class AutorDAO {
    private Connection connection;

    public AutorDAO(Connection connection) {
        this.connection = connection;
    }
    
    
    
    public void createAutor(Autor autor, Musica musica){
        try {
            String sql = "INSERT INTO Autor VALUES (DEFAULT, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, autor.getCpf());
                pstm.setString(2, autor.getNome_original());
                pstm.setString(3, autor.getNome_artistico());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                	while (rst.next()) {
                    	autor.set_id_autor(rst.getInt(1));
                	}
                }
                
            }
            
            if(musica != null) { 
            String sqlRelationship = "INSERT INTO MusicaAutor VALUES (DEFAULT, ?, ?)";

            try (PreparedStatement pstm2 = connection.prepareStatement(sqlRelationship, Statement.RETURN_GENERATED_KEYS)) {
                pstm2.setInt(1, musica.get_id_musica());
                pstm2.setInt(2, autor.get_id_autor());

                pstm2.execute();
            }
            
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    };

    public Autor retrieveAutor(String nome_autor) {
        try {
            String sql = "SELECT * FROM Autor WHERE nome_art === ?";

            Autor autor;

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, nome_autor);
                pstm.execute();

                ResultSet result = pstm.getResultSet();

                int id = result.getInt("id_autor");
                String cpf = result.getString("cpf");
                String nome_original = result.getString("nome_orig");
                String nome_artistico = result.getString("nome_art");
                autor = new Autor(id, cpf, nome_original, nome_artistico);

            }

            return autor;
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
    };

    public ArrayList<Autor> retrieveAllAutores() {

        ArrayList<Autor> autores = new ArrayList<Autor>();

        try {
            String sql = "SELECT * FROM Autor";

            try(PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                ResultSet result = pstm.getResultSet();

                while (result.next()) {
                    int id = result.getInt("id_autor");
                    String cpf = result.getString("cpf");
                    String nome_original = result.getString("nome_orig");
                    String nome_artistico = result.getString("nome_art");
                    Autor autor = new Autor(id, cpf, nome_original, nome_artistico);
                    autores.add(autor);
                }

            }

            return autores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    public void deleteAutor(Autor autor) {
        try {
            String sql = "DELETE FROM Autor WHERE id_autor === ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, autor.get_id_autor());
                pstm.execute();
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
    };

    public void updateAutor(Autor autor) {
         try {
            String sql = "UPDATE Autor SET cpf = ?, nome_art = ?, nome_orig = ? WHERE id_autor === ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, autor.getCpf());
                pstm.setString(2, autor.getNome_artistico());
                pstm.setString(3, autor.getNome_original());
                pstm.setInt(4, autor.get_id_autor());
                pstm.execute();
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
    }

}
