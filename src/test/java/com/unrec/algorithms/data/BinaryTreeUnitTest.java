package com.unrec.algorithms.data;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryTreeUnitTest {

    private BinaryTree tree = new BinaryTree();

    static Stream<Arguments> intValues() {
        return Stream.of(Arguments.arguments(new int[]{15, 8, 5, 36, 4, 6, 10, 12, 7, 9}));
    }

    @ParameterizedTest
    @MethodSource("intValues")
    void addNode_Success(int[] values) {

        //given
        populateTree(values);

        //when
        tree.add(1);

        //then
        assertTrue(tree.contains(1));
    }

    @ParameterizedTest
    @MethodSource("intValues")
    void findNode_Success(int[] values) {

        //given
        populateTree(values);

        //then
        for (int value : values) {
            assertTrue(tree.contains(value));
        }
    }

    private void populateTree(int[] values) {
        for (int value : values) {
            tree.add(value);
        }
    }
}