import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MainTest {

    @BeforeAll
    static void mainStart(){
        System.out.println("Tests start");
    }

    @AfterAll
    static void mainEnd(){
        System.out.println("Tests end");
    }

    @DisplayName("check sides")
    @Test
    void test1() {
        Assertions.assertEquals(true, Main.checkIfSidesOfArrayEqual(new int[] {2, 2, 2, 1, 2, 2, 10, 1}));
    }



    @DisplayName("Parameterized test")
    @ParameterizedTest
    @MethodSource("data")
    void paramTest(boolean expected, int[] arr){
        Assertions.assertEquals(expected, Main.checkIfSidesOfArrayEqual(arr));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(true, new int[] {2, 2, 2, 1, 2, 2, 10, 1}),
                Arguments.arguments(false, new int[] {2, 21, 2, 1, 2, 2, 10, 1}),
                Arguments.arguments(true, new int[] {2, 2, 2, 6})
        );
    }

    @DisplayName("Parameterized test2")
    @ParameterizedTest
    @MethodSource("data2")
    void paramTest2(Integer[] expected, Integer[] arr, int shifts){
        Assertions.assertArrayEquals(expected, Main.shiftArray(arr, shifts));
    }

    static Stream<Arguments> data2() {
        return Stream.of(
                Arguments.arguments(new Integer[] {3, 5, 6, 1}, new Integer[] {6, 1, 3, 5}, -2),
                Arguments.arguments(new Integer[] {3, 5, 6, 1}, new Integer[] {6, 1, 3, 5}, -3)
        );
    }


}