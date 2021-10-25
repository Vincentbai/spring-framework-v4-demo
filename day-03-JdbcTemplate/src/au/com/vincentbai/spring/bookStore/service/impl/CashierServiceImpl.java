package au.com.vincentbai.spring.bookStore.service.impl;

import au.com.vincentbai.spring.bookStore.service.BookStoreService;
import au.com.vincentbai.spring.bookStore.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CashierServiceImpl implements CashierService {

    @Autowired
    private BookStoreService bookStoreService;
    
    @Override
    public void checkOut(String uid, List<String> bids) {

        for (String bid: bids) {
            bookStoreService.buyBook(bid, uid);
        }

    }
}
