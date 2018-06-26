package iyte.edu.year2018.ceng437.hw01.test;

import iyte.edu.year2018.ceng437.hw01.DeliveryDay;
import iyte.edu.year2018.ceng437.hw01.Menu;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;


public class MenuTest {

    private Menu menu;

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Before
    public void setUp() {
        menu = new Menu();
    }

    @After
    public void tearDown() {
        menu = null;
    }

    @Test
    public void readPurchaseAmount() {
        systemInMock.provideLines("8", "52", "102", "0");

        assertThat(menu.readPurchaseAmount(), is(8));
        assertThat(menu.readPurchaseAmount(), is(52));
        assertThat(menu.readPurchaseAmount(), is(102));
        assertThat(menu.readPurchaseAmount(), is(0));
    }

    @Test
    public void readNumberOfItems() {
        systemInMock.provideLines("0", "2", "3", "4");

        assertThat(menu.readNumberOfItems(), is(0));
        assertThat(menu.readNumberOfItems(), is(2));
        assertThat(menu.readNumberOfItems(), is(3));
        assertThat(menu.readNumberOfItems(), is(4));
    }

    @Test
    public void readDeliveryDay() {
        systemInMock.provideLines("1", "2", "3");

        assertThat(menu.readDeliveryDay(), is(DeliveryDay.NEXT_DAY));
        assertThat(menu.readDeliveryDay(), is(DeliveryDay.IN_TWO_DAYS));
        assertThat(menu.readDeliveryDay(), is(DeliveryDay.IN_A_WEEK));
    }

    @Test(expected = NullPointerException.class)
    public void closeMenu() {
        systemInMock.provideLines("5", "4", "100");

        menu.closeMenu();
        menu.readPurchaseAmount();
        menu.readNumberOfItems();
        menu.readDeliveryDay();
    }

}