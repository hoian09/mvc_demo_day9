package mvc.repository;

import mvc.entity.OrderDetailEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepository extends CrudRepository<OrderDetailEntity, Integer> {

}
