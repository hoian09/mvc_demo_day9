package mvc.repository;


import mvc.entity.OrdersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.Order;
import java.util.List;

public interface OrdersRepository extends CrudRepository<OrdersEntity, Integer> {

}
