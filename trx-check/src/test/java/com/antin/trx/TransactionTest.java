package com.antin.trx;


import com.antin.util.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by antin on 8/3/16.
 */
public class TransactionTest {
    private WebDriver driver;

    private final String XPATH_TRX_ID = "//*[@id=\"app\"]/div/div[2]/div[1]";
    private final String XPATH_SELLER_NAME = "//*[@id=\"app\"]/div/div[2]/div[2]";
    private final String XPATH_DATE_ORDER = "//*[@id=\"app\"]/div/div[2]/div[3]";
    private final String XPATH_SHIPMENT_ADDRESS = "//*[@id=\"app\"]/div/div[2]/div[4]";
    private final String XPATH_DELIVERY_SERVICE = "//*[@id=\"app\"]/div/div[2]/div[5]";

    /**
     * TODO
     * should get from previous test case (create order)
     */
    private String sellerName = "FURHAN";
    private String shipmentAddress = "Jalan Gourney";
    private String deliveryService = "REX";


    @Before
    public void setUp() {
        driver = Driver.getFirefoxDriver();

        /**
         * TODO
         * Prerequisite 	: Create order with valid Data
         * should executed as 1 flow
         */
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkSuccessOrder() {
        //transaction id
        WebElement trxId = driver.findElement(By.xpath(XPATH_TRX_ID));

        assertNotNull(trxId);
        /**
         * TODO
         * should assert equal with generated util by developer
         */

        //seller name
        WebElement seller = driver.findElement(By.xpath(XPATH_SELLER_NAME));

        assertNotNull(seller);
        assertEquals(sellerName, seller);

        //delivery service
        WebElement delivery = driver.findElement(By.xpath(XPATH_DELIVERY_SERVICE));
        assertNotNull(delivery);
        assertEquals(deliveryService, delivery);

        //shipment address
        WebElement address = driver.findElement(By.xpath(XPATH_SHIPMENT_ADDRESS));
        assertNotNull(address);
        assertEquals(shipmentAddress, address);
        
         //date
        WebElement date = driver.findElement(By.xpath(XPATH_DATE_ORDER));
        assertNotNull(date);
        assertEquals(getToday(), date);
    }
    
    private String getToday() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(new Date());
    }


}
