package com.java.inventory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockDAOImpl implements StockDAO {

    @Override
    public boolean addStock(Stock stock) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = ConnectionHelper.getConnection();
        String nextStockId = generateNextStockId();
        if (nextStockId == null) {
            throw new SQLException("Failed to generate the next StockId.");
        }

        String sql = "INSERT INTO stock (stockid, ItemName, Price, QuantityAvail) VALUES (?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nextStockId);
        preparedStatement.setString(2, stock.getItemName());
        preparedStatement.setDouble(3, stock.getPrice());
        preparedStatement.setInt(4, stock.getQuantityAvail());

        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted <= 0) {
            throw new SQLException("Failed to insert the stock record.");
        }

        return true; 
    }

    private String generateNextStockId() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        connection = ConnectionHelper.getConnection();

        String sql = "SELECT MAX(stockid) FROM stock";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String latestStockId = resultSet.getString(1);

            if (latestStockId != null) {
                int numericPart = Integer.parseInt(latestStockId.substring(1));
                numericPart++;
                String nextStockId = String.format("S%03d", numericPart);

                return nextStockId;
            } else {
                return "S001";
            }
        }

        return null;
    }
        @Override
        public Stock searchStock(String stockId) throws SQLException, ClassNotFoundException {
            Stock stock = null;
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            connection = ConnectionHelper.getConnection();
            String sql = "SELECT * FROM stock WHERE stockid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, stockId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                stock = new Stock();
                stock.setStockId(resultSet.getString("stockid"));
                stock.setItemName(resultSet.getString("ItemName"));
                stock.setPrice(resultSet.getDouble("Price"));
                stock.setQuantityAvail(resultSet.getInt("QuantityAvail"));
            }

            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

            return stock;
        }

        @Override
        public List<Stock> showStock() throws SQLException, ClassNotFoundException {
            List<Stock> stockList = new ArrayList<>();
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            connection = ConnectionHelper.getConnection();
            String sql = "SELECT * FROM stock";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Stock stock = new Stock();
                stock.setStockId(resultSet.getString("stockid"));
                stock.setItemName(resultSet.getString("ItemName"));
                stock.setPrice(resultSet.getDouble("Price"));
                stock.setQuantityAvail(resultSet.getInt("QuantityAvail"));

                stockList.add(stock);
            }

            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

            return stockList;
        }

        @Override
        public boolean placeOrder(String stockId, int quantityOrdered) throws SQLException, ClassNotFoundException {
            Connection connection = ConnectionHelper.getConnection();
            connection.setAutoCommit(false);

            String checkQuantitySql = "SELECT QuantityAvail FROM stock WHERE stockid = ?";
            PreparedStatement updateStockStatement = connection.prepareStatement(checkQuantitySql);
            updateStockStatement.setString(1, stockId);
            int availableQuantity = 0;
            try (ResultSet resultSet = updateStockStatement.executeQuery()) {
                if (resultSet.next()) {
                    availableQuantity = resultSet.getInt("QuantityAvail");
                }
            }

            if (quantityOrdered > availableQuantity) {
                throw new IllegalArgumentException("QuantityOrdered exceeds available quantity.");
            }

            String insertOrderSql = "INSERT INTO Orders (OrderId, StockID, QtyOrd, billAmount) VALUES (?, ?, ?, ?)";
            PreparedStatement orderStatement = connection.prepareStatement(insertOrderSql);
            orderStatement.setString(1, generateNextOrderId());
            orderStatement.setString(2, stockId);
            orderStatement.setInt(3, quantityOrdered);
            double billAmount = calculateBillAmount(stockId, quantityOrdered);
            orderStatement.setDouble(4, billAmount);

            int rowsInserted = orderStatement.executeUpdate();

            String updateStockSql = "UPDATE stock SET QuantityAvail = ? WHERE stockid = ?";
            updateStockStatement = connection.prepareStatement(updateStockSql);
            updateStockStatement.setInt(1, availableQuantity - quantityOrdered);
            updateStockStatement.setString(2, stockId);
            updateStockStatement.executeUpdate();

            String updateAmountSql = "UPDATE Amount SET Gamt = Gamt + ?";
            PreparedStatement updateAmountStatement = connection.prepareStatement(updateAmountSql);
            updateAmountStatement.setDouble(1, billAmount);
            updateAmountStatement.executeUpdate();

            connection.commit();

            return rowsInserted > 0;
        }


        private String generateNextOrderId() throws SQLException, ClassNotFoundException {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            connection = ConnectionHelper.getConnection();
            String sql = "SELECT MAX(OrderId) FROM Orders";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String latestOrderId = resultSet.getString(1);

                if (latestOrderId != null) {
                    int numericPart = Integer.parseInt(latestOrderId.substring(1));
                    numericPart++;
                    String nextOrderId = String.format("O%03d", numericPart);

                    return nextOrderId;
                } else {
                    return "O001";
                }
            }

            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

            return null; 
        }
        private double calculateBillAmount(String stockId, int quantityOrdered) throws SQLException, ClassNotFoundException {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                String sql = "SELECT Price FROM stock WHERE stockid = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, stockId);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    double price = resultSet.getDouble("Price");
                    return price * quantityOrdered;
                } else {
                    throw new IllegalArgumentException("Stock item not found for stockId: " + stockId);
                }
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
}
        








