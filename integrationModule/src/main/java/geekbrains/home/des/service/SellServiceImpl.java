package geekbrains.home.des.service;

import geekbrains.home.des.DAO.SellDAO;
import geekbrains.home.des.domain.Sell;
import org.springframework.stereotype.Service;

@Service
public class SellServiceImpl implements SellService {
    private final SellDAO sellDAO;

    public SellServiceImpl(SellDAO sellDAO) {
        this.sellDAO = sellDAO;
    }

    @Override
    public void save(Sell sell) {
        if (sell != null) {
            sellDAO.save(sell);
        }
    }
}
