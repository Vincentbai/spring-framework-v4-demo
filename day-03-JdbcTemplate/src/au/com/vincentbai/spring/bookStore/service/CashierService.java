package au.com.vincentbai.spring.bookStore.service;

import java.util.List;

public interface CashierService {
    void checkOut(String uid, List<String> bids);
}
