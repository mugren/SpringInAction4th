package orders.db;

import orders.Order;

import java.util.List;

public interface OrderOperations {
	
	List<Order> findNeuromancerOrders();

}
