package orderbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class OrderBook {
    
    TreeMap<Double, List<Order>> buyOrders = new TreeMap<>(Collections.reverseOrder());
    TreeMap<Double, List<Order>> sellOrders = new TreeMap<>();
    HashMap<String, Order> orderMap = new HashMap<>();

    public void addOrder(Order order) {
        TreeMap<Double, List<Order>> refTreeMap = order.getIsBuyOrder() ? buyOrders : sellOrders;
        refTreeMap.putIfAbsent(order.getPrice(), new ArrayList<>());
        refTreeMap.get(order.getPrice()).add(order);
        orderMap.put(order.getId(), order);
    }
    
    //remove Order
    
    //view Orders

}
