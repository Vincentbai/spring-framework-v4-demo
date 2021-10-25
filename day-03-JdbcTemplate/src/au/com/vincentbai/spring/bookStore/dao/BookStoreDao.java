package au.com.vincentbai.spring.bookStore.dao;

public interface BookStoreDao {

    Integer getPrice(String bid);

    void updateStock(String bid);

    void updateBalance(String uid, Integer price);

}
