package br.com.infox.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModuloConexao {

    public static Connection conector() {
        Connection conexao = null;

        // Driver PostgreSQL
        String driver = "org.postgresql.Driver";

        // URL de conexão correta (SSL obrigatório no Supabase)
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:5432/postgres?sslmode=require";

        // Usuário e senha do Supabase (copie exatamente do painel)
        String user = "postgres.kggcmozrovsstylfirgm";
        String password = "h2q606m3zdDl4aYD"; // substitua pela senha real do Supabase

        try {
            // Carregar driver
            Class.forName(driver);

            // Estabelecer conexão
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver PostgreSQL não encontrado!");
            return null;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro a conectar com o supaBase!, Tente novamente.");
            return null;
        }
    }
}
