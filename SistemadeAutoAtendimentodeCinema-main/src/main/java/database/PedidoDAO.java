
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PedidoDAO {

    public void salvarPedido(String filme, String horario, String poltronas, String dia, String metodoPagamento) {
        String sql = "INSERT INTO pedido (filme, horario, poltronas, dia, metodo_pagamento) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, filme);
            stmt.setString(2, horario);
            stmt.setString(3, poltronas);
            stmt.setString(4, dia);
            stmt.setString(5, metodoPagamento);

            stmt.executeUpdate();
            System.out.println("Pedido salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
