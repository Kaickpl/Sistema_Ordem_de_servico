package br.com.infox.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            System.out.println("Conexão com Supabase estabelecida!");
            return conexao;

        } catch (ClassNotFoundException e) {
            System.out.println("Driver PostgreSQL não encontrado!");
            e.printStackTrace();
            return null;

        } catch (SQLException e) {
            System.out.println("Erro ao conectar com Supabase!");
            e.printStackTrace();
            return null;
        }
    }

    // Teste rápido
    public static void main(String[] args) {
        Connection con = conector();
        if (con != null) {
            System.out.println("Teste de conexão OK!");
        } else {
            System.out.println("Falha na conexão.");
        }
    }
}
