import java.util.*;
import java.util.stream.Collectors;

class Stock {
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Portfolio {
    private Map<String, Integer> stocks = new HashMap<>();

    public void buyStock(Stock stock, int quantity) {
        stocks.put(stock.getSymbol(), stocks.getOrDefault(stock.getSymbol(), 0) + quantity);
    }

    public void sellStock(Stock stock, int quantity) {
        int currentQuantity = stocks.getOrDefault(stock.getSymbol(), 0);
        if (currentQuantity >= quantity) {
            stocks.put(stock.getSymbol(), currentQuantity - quantity);
        } else {
            System.out.println("Not enough shares to sell.");
        }
    }

    public double calculatePortfolioValue(List<Stock> allStocks) {
        return stocks.entrySet().stream()
            .mapToDouble(entry -> {
                Stock stock = allStocks.stream()
                    .filter(s -> s.getSymbol().equals(entry.getKey()))
                    .findFirst()
                    .orElse(null);

                if (stock != null) {
                    return stock.getPrice() * entry.getValue();
                } else {
                    return 0;
                }
            })
            .sum();
    }
}

public class StockTradingSystem {
    public static void main(String[] args) {
        List<Stock> allStocks = new ArrayList<>();
        allStocks.add(new Stock("AAPL", 150.0));
        allStocks.add(new Stock("GOOGL", 2700.0));
        allStocks.add(new Stock("TSLA", 750.0));

        Portfolio portfolio = new Portfolio();
        portfolio.buyStock(allStocks.get(0), 10);
        portfolio.buyStock(allStocks.get(1), 5);

        // Simulate stock price updates
        Random random = new Random();
        for (Stock stock : allStocks) {
            stock.setPrice(stock.getPrice() + (random.nextDouble() - 0.5) * 10);
        }

        System.out.println("Portfolio Value: $" + portfolio.calculatePortfolioValue(allStocks));

        // Additional analysis or visualization can be done here
        // For instance, you can use external libraries for charting and data visualization
    }
}
