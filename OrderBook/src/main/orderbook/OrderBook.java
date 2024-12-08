package orderbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    public boolean removeOrders(String orderId) {
        Order order = orderMap.remove(orderId);
        if(order==null) {
            return false;
        }
        TreeMap<Double, List<Order>> refTreeMap = order.getIsBuyOrder() ? buyOrders : sellOrders;
        List<Order> ordersAtPrice = refTreeMap.get(order.getPrice());
        ordersAtPrice.remove(order);
        if(ordersAtPrice.isEmpty()) {
            refTreeMap.remove(order.getPrice());
        }
        return true;
    }
    
    public void viewOrder() {
        System.out.println("Buy Orders are: ");
        for(Map.Entry<Double, List<Order>> entry : buyOrders.entrySet()) {
            System.out.println("Price: "+entry.getKey()+" -> "+entry.getValue());
        }

        System.out.println("Sell Order are: ");
        for(Map.Entry<Double, List<Order>> entry : sellOrders.entrySet()) {
            System.out.println("Price: "+entry.getKey()+" -> "+entry.getValue());
        }
    }

}
