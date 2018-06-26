package iyte.edu.year2018.ceng437.hw01.test;

import iyte.edu.year2018.ceng437.hw01.DeliveryDay;
import iyte.edu.year2018.ceng437.hw01.Shipment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ShipmentTest {

    private Shipment shipment;

    private int purchaseAmount;
    private int numberOfItems;
    private DeliveryDay deliveryDay;

    private int expectedPurchaseAmount;
    private int expectedNumberOfItems;
    private DeliveryDay expectedDeliveryDay;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, 0, DeliveryDay.NEXT_DAY, 0, 0, DeliveryDay.NEXT_DAY},

                {10, 0, DeliveryDay.NEXT_DAY, 10, 0, DeliveryDay.NEXT_DAY},
                {1000, 0, DeliveryDay.NEXT_DAY, 1000, 0, DeliveryDay.NEXT_DAY},

                {0, 1, DeliveryDay.NEXT_DAY, 0, 1, DeliveryDay.NEXT_DAY},
                {0, 4, DeliveryDay.NEXT_DAY, 0, 4, DeliveryDay.NEXT_DAY},

                {0, 0, DeliveryDay.IN_TWO_DAYS, 0, 0, DeliveryDay.IN_TWO_DAYS},
                {0, 0, DeliveryDay.IN_A_WEEK, 0, 0, DeliveryDay.IN_A_WEEK}
        });
    }

    public ShipmentTest(int purchaseAmount, int numberOfItems, DeliveryDay deliveryDay, int expectedPurchaseAmount, int expectedNumberOfItems, DeliveryDay expectedDeliveryDay) {
        this.purchaseAmount = purchaseAmount;
        this.numberOfItems = numberOfItems;
        this.deliveryDay = deliveryDay;

        this.expectedPurchaseAmount = expectedPurchaseAmount;
        this.expectedNumberOfItems = expectedNumberOfItems;
        this.expectedDeliveryDay = expectedDeliveryDay;
    }

    @Before
    public void setUp() {
        shipment = new Shipment(this.purchaseAmount, this.numberOfItems, this.deliveryDay);
    }

    @After
    public void tearDown() {
        shipment = null;
    }

    @Test
    public void getPurchaseAmount() {
        assertThat(shipment.getPurchaseAmount(), is(this.expectedPurchaseAmount));
    }

    @Test
    public void getNumberOfItems() {
        assertThat(shipment.getNumberOfItems(), is(this.expectedNumberOfItems));
    }

    @Test
    public void getDeliveryDay() {
        assertThat(shipment.getDeliveryDay(), is(this.expectedDeliveryDay));
    }

    @Test
    public void setPurchaseAmount() {
        shipment.setPurchaseAmount(this.purchaseAmount);
        assertThat(shipment.getPurchaseAmount(), is(this.expectedPurchaseAmount));
    }

    @Test
    public void setNumberOfItems() {
        shipment.setNumberOfItems(this.numberOfItems);
        assertThat(shipment.getNumberOfItems(), is(this.expectedNumberOfItems));
    }

    @Test
    public void setDeliveryDay() {
        shipment.setDeliveryDay(this.deliveryDay);
        assertThat(shipment.getDeliveryDay(), is(this.expectedDeliveryDay));
    }
}