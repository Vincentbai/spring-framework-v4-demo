package au.com.vincentbai.spring.bookStore.service.impl;

import au.com.vincentbai.spring.bookStore.exception.MyException;
import au.com.vincentbai.spring.bookStore.service.BookStoreService;
import au.com.vincentbai.spring.bookStore.dao.BookStoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Transactional 如果放在類上，對該類中的所有的方法都有作用
 *
 * @Transactional 可以設置的屬性：
 *
 * 1. propagation: 事務的傳播行爲, A 和 B 都有事務，儅 A 調用 B 中的方法時， A 會將自身的事務傳遞給 B，B 可以選擇用不用 A 傳遞過來的事務
 *                 propagation = Propagation.REQUIRED 使用 A 傳遞過來的事務
 *                 propagation = Propagation.REQUIRE_NEW 不適用 A 傳遞過來的事務，使用自身的事務，A 的事務被挂起
 * 2. isolation:
 *              1. 讀未提交（針對於某個字段）：可以讀取未提交的數據，產生的問題 ”賍讀“：20 -> 30, 能讀取到30，如果回滾到20，則讀取一些沒有意義的數據
 *              2. 讀已提交（針對於某個字段）：只能讀取已經提交的數據，產生的問題 ”不可重複讀“：20 -> 30，第一次讀是20，如果該事務提交，後來再讀變成了30
 *              4. 可重複讀（針對於某行數據 mysql 默認的隔離級別）：我操作的數據，別的用戶不能進行任何修改操作（包括讀取），但是別的用戶可以添加新的數據，所有會產生”幻讀“，第一次查只有10條數據，第二次查就有20條數據了
 *              8. 串行化：用戶對數據庫的請求串起來，相當於單綫程，一次只能操作一個請求，性能低，消耗大
 *              在并發的情況下，操作數據的一種規定
 * 3. timeout: 在事務强制回滾之前最多可以執行（等待）的時間，（模擬并發工具 AD）
 *
 * 4. readOnly: 指定當前事務中的一系列操作是否為只讀，默認為false，mysql有鎖的概念，多綫程加鎖，儅一個用戶對某條數據進行操作時，mysql會為該條數據加鎖，別的用戶不能做任何操作，包括讀取
 *              如果設置readOnly = true，spring 就會告訴 mysql 該事務中都是讀的操作，不需要加鎖，提升性能
 *              如果有讀有寫，不能設置為 true，會產生髒讀，幻讀，不可重複讀
 *
 * 5. rollbackFor | rollbackForClassName | noRollBackFor | noRollbackForClassName: 爲什麽回滾，爲什麽不回滾
 *
 */


@Transactional
@Service
public class BookStoreServiceImpl implements BookStoreService {

    @Autowired
    private BookStoreDao dao;

    @Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.DEFAULT, timeout=3, readOnly = false, rollbackFor = {NullPointerException.class, MyException.class})
    @Override
    public void buyBook(String bid, String uid) {

        // 測試 timeout
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // 一般业务逻辑都放在service中， dao中只放单个业务逻辑
        Integer price = dao.getPrice(bid);
        dao.updateStock(bid);
        dao.updateBalance(uid,price);


    }
}
