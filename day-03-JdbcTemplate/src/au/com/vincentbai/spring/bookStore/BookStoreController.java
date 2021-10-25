package au.com.vincentbai.spring.bookStore;

import au.com.vincentbai.spring.bookStore.service.BookStoreService;
import au.com.vincentbai.spring.bookStore.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookStoreController {

    @Autowired
    private BookStoreService bookStoreService;

    @Autowired
    private CashierService cashierService;

    public void buyBook(){
        bookStoreService.buyBook("1", "1001");
    }

    public void checkOut(){
        List<String> bids = new ArrayList<>();
        bids.add("1");
        bids.add("2");
        cashierService.checkOut("1001", bids);
    }


}
