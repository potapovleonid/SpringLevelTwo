package geekbrains.home.des.domain;

import java.util.List;

public class Purchase {
    private Long purchaseID;

    private List<Sell> sells;

    public List<Sell> getSells() {
        return sells;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseID=" + purchaseID +
                ", sells=" + sells +
                '}';
    }
}
