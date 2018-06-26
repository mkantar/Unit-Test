package iyte.edu.year2018.ceng437.hw01.test;

import iyte.edu.year2018.ceng437.hw01.DecisionTable;
import iyte.edu.year2018.ceng437.hw01.DeliveryDay;
import iyte.edu.year2018.ceng437.hw01.Shipment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class DecisionTableTest {

    private Shipment shipment;
    private DecisionTable table;

    private int purchaseAmount;
    private int numberOfItems;
    private DeliveryDay deliveryDay;

    private double expectedCost;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {99, 2, DeliveryDay.NEXT_DAY, 25.0},
                {99, 2, DeliveryDay.IN_TWO_DAYS, 10.0},
                {99, 2, DeliveryDay.IN_A_WEEK, 3.0},
                {99, 3, DeliveryDay.NEXT_DAY, 25.0},
                {99, 3, DeliveryDay.IN_TWO_DAYS, 10.0},
                {99, 3, DeliveryDay.IN_A_WEEK, 4.5},
                {99, 4, DeliveryDay.NEXT_DAY, 24.0},
                {99, 4, DeliveryDay.IN_TWO_DAYS, 10.0},
                {99, 4, DeliveryDay.IN_A_WEEK, 0},

                {100, 2, DeliveryDay.NEXT_DAY, 25.0},
                {100, 2, DeliveryDay.IN_TWO_DAYS, 10.0},
                {100, 2, DeliveryDay.IN_A_WEEK, 3.0},
                {100, 3, DeliveryDay.NEXT_DAY, 25.0},
                {100, 3, DeliveryDay.IN_TWO_DAYS, 10.0},
                {100, 3, DeliveryDay.IN_A_WEEK, 4.5},
                {100, 4, DeliveryDay.NEXT_DAY, 24.0},
                {100, 4, DeliveryDay.IN_TWO_DAYS, 10.0},
                {100, 4, DeliveryDay.IN_A_WEEK, 0},

                {101, 2, DeliveryDay.NEXT_DAY, 35.0},
                {101, 2 ,DeliveryDay.IN_TWO_DAYS, 15.0},
                {101, 2, DeliveryDay.IN_A_WEEK, 10.0},
                {101, 3, DeliveryDay.NEXT_DAY, 35.0},
                {101, 3, DeliveryDay.IN_TWO_DAYS, 15.0},
                {101, 3, DeliveryDay.IN_A_WEEK, 10.0},
                {101, 4, DeliveryDay.NEXT_DAY, 30.0},
                {101, 4, DeliveryDay.IN_TWO_DAYS, 14.0},
                {101, 4, DeliveryDay.IN_A_WEEK, 10.0}

        });
    }

    public DecisionTableTest(int purchaseAmount, int numberOfItems, DeliveryDay deliveryDay, double expectedCost) {
        this.purchaseAmount = purchaseAmount;
        this.numberOfItems = numberOfItems;
        this.deliveryDay = deliveryDay;
        this.expectedCost = expectedCost;
    }

    @Before
    public void setUp() {
        shipment = new Shipment(this.purchaseAmount, this.numberOfItems, this.deliveryDay);
        table = new DecisionTable();
    }

    @After
    public void tearDown() {
        shipment = null;
        table = null;
    }

    @Test
    public void calculateShipmentCost() {
        assertThat(table.calculateShipmentCost(this.shipment), is(this.expectedCost));
    }
}