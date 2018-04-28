package com.epam.tasks.utils;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Utils Test.
 */
@RunWith(JUnit4.class)
public class UtilsTest {

    private static final String FIRST = "home";
    private static final String SECOND = "table";
    private static final String THIRD = "test";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // logic for 'BeforeClass'
    }

    @Before
    public void setUp() throws Exception {
        // logic for 'Before'
    }

    @Test
    public void utilsTest_concatenateWords() {
        String expectedResult = String.join(" ", FIRST, SECOND, THIRD);

        String actualResult = Utils.concatenateWords(FIRST, SECOND, THIRD);

        assertEquals("Expected result is wrong!", expectedResult, actualResult);
    }

    @Test
    public void utilsTest_computeFactorial() {
        Long expectedResult = 24l;
        Long actualFactorial = Utils.computeFactorial(4);
        assertEquals("wrong calculation!", expectedResult, actualFactorial);
    }

    @Test
    public void utilsTest_computeFactorial1() {
        Long expectedResult = 2432902008176640000l;
        Long actualFactorial = Utils.computeFactorial(20);
        assertEquals("wrong calculation!", expectedResult, actualFactorial);
    }

    @Test(timeout = 100000)
    public void utilsTest_factorialWithTimeout() {
        Utils.computeFactorial(new Random().nextInt());
    }

    @Test(expected = IllegalArgumentException.class)
    public void utilsTest_expectedException() {
        Utils.computeFactorial(-5);
    }

    @Test
    @Ignore
    public void testNormalizeWord() {
        String concatenateWords = Utils.concatenateWords(FIRST, SECOND, THIRD);
        String[] strings = concatenateWords.split(" ");
        assertNotNull(strings);
    }

    @After
    public void clean() {
        // logic for 'After'
    }

    @AfterClass
    public static void cleanAfterClass() {
        // logic for 'AfterClass'
    }

}
