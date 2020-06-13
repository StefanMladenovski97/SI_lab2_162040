import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {



//created by Jovan Davchev


    private List<Double> createList(Double... elems) {
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    void everyStatementAndBranchTest() {
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () -> LabExample.sumOfPricesGreaterThan(null, 5d));
        assertTrue(ex.getMessage().contains("List of prices is not ok"));

        ex = assertThrows(RuntimeException.class,
                () -> LabExample.sumOfPricesGreaterThan(createList(1d, 3d, -2d), 2d));
        assertTrue(ex.getMessage().contains("Negative price is not allowed"));

        assertEquals(9d, LabExample.sumOfPricesGreaterThan(createList(1d, 4d, 5d), 2d));
    }

    @Test
    void multipleConditionsTest() {
        //(prices==null || prices.isEmpty())
        //T || X
        //F || T
        //F || F

        RuntimeException ex;

        ex = assertThrows(RuntimeException.class,
                () -> LabExample.sumOfPricesGreaterThan(null, 5d));
        assertTrue(ex.getMessage().contains("List of prices is not ok"));

        ex = assertThrows(RuntimeException.class,
                () -> LabExample.sumOfPricesGreaterThan(Collections.emptyList(), 5d));
        assertTrue(ex.getMessage().contains("List of prices is not ok"));

        assertEquals(5d, LabExample.sumOfPricesGreaterThan(createList(2d, 3d), 1d));

    }

}