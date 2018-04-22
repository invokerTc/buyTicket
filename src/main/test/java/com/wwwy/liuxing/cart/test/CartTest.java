package com.wwwy.liuxing.cart.test;

import com.sun.xml.internal.txw2.annotation.XmlAttribute;
import com.wwwy.liuxing.cart.dto.CartDTO;
import com.wwwy.liuxing.cart.service.ICartService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class CartTest {
    private Logger logger = Logger.getLogger(CartTest.class);
    private int num = 10000;
    private CountDownLatch conuntDownLatch = new CountDownLatch(num);
    @Autowired
    private ICartService cartService;

    @Test
    public void testCase1() {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCinemaName("wanda");
        cartDTO.setHallName("vipHall");
        cartDTO.setMovieName("kongfu");
        cartDTO.setWatchingTime("12:00");
        cartDTO.setSelectedSets("2-3，4-6，3-5");
        System.out.println(cartDTO);
        try {
            String s = cartService.saveCartDetail("13579", cartDTO,"abc","12:00");
            logger.info(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug("测试结束");
    }

    @Test
    public void testCase2() {
        CartDTO cartDTO = null;
        try {
            cartDTO = cartService.getCartDetail("13245645433", "", "红海行动");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug(cartDTO.getMovieName());
        logger.debug(cartDTO.getWatchingTime());
        logger.debug(cartDTO.getSelectedSets());
        logger.debug("请求ok");
    }

    @Test
    public void testCase3() {
        List<String> setList = null;
        try {
            setList = cartService.getSetList("2排6座,3排3座,5排5座,4排8座");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String str : setList) {
            logger.debug(str);
        }
    }

    @Test
    public void testCase4() {
        logger.info("testCase4------start");
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Random random = new Random();
        for (int i = 1; i < 1000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    CartDTO cartDTO = new CartDTO();
                    cartDTO.setCinemaName("wanda");
                    cartDTO.setHallName("vipHall");
                    cartDTO.setMovieName("kongfu");
                    cartDTO.setWatchingTime("12:00");
                    cartDTO.setSelectedSets("5-1");
                    String str = random.nextInt() + "";
                    try {
                        String s = cartService.saveCartDetail(str, cartDTO,"头号玩家","19:45");
                        logger.info(Thread.currentThread().getName() + "=======" + str + "============" + s);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        try {
            conuntDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("testCase4------end");
    }
    @Test
    public void testCase5(){
        logger.info("testCase5------start");
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Random random = new Random();
        for (int i = 1; i < 2; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    String str = random.nextInt() + "";
                    String s = cartService.conmmitOrder(str,"1","1-5,2-6,3-6");
                    logger.info(Thread.currentThread().getName() + "=======" + str + "============" + s);
                }
            });
        }
        try {
            conuntDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
