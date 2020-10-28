package geekbrains.home.des.DAO;

import geekbrains.home.des.domain.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellDAO extends JpaRepository<Sell, Long> {
}
