package orders.db;

import java.util.List;

import orders.Order;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface OrderRepository extends GraphRepository<Order>, OrderOperations {
	
	List<Order> findByCustomer(String customer);
	
	List<Order> findByCustomerLike(String customer);

	List<Order> findByCustomerAndType(String customer, String type);

	List<Order> getByType(String type);

	@Query("match (o:Order)-[:HAS_ITEMS]->(i:Item) " +
			"where i.product='Spring in Action' return o")
	List<Order> findSiAOrders();

}
