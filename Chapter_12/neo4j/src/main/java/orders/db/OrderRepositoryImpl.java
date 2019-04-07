package orders.db;

import orders.Order;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.data.neo4j.template.Neo4jOperations;

import java.util.List;
import java.util.Map;

public class OrderRepositoryImpl implements OrderOperations {

    @Autowired
    Neo4jOperations neo4j;

    @Override
    public List<Order> findNeuromancerOrders() {
        Result<Map<String, Object>> result = neo4j.query(
                "match (o:Order)-[:HAS_ITEMS]->(i:Item) " +
                        "where i.product='Neuromancer' return o", null);
        Result<Order> endResult = result.to(Order.class);
        return IteratorUtil.asList(endResult);
    }
}
