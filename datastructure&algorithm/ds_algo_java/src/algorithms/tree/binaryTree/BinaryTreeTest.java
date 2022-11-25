package algorithms.tree.binaryTree;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    static BinaryTree bt;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();//출력테스트용
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));//출력테스트용
        
        bt= new BinaryTree();
        bt = bt.createBinaryTree();//3456789트리 만듦


    }

    @Test
    public void 값이포함되어있는지확인(){
        //given
        //before에서 처리
        //when
        boolean result0 = bt.containsNode(6);
        boolean result1 = bt.containsNode(4);
        boolean result2 = bt.containsNode(2);

        // then
        assertTrue(result0);
        assertTrue(result1);
        assertFalse(result2);

    }

    @Test
    public void 삭제처리확인(){
        boolean beforeDelete = bt.containsNode(6);
        bt.delete(6);
        boolean afterDelete = bt.containsNode(6);

        assertTrue(beforeDelete);
        assertFalse(afterDelete);
    }
    @Test
    public void preOrder확인(){
        bt.traversePreOrder(bt.root);
        assertEquals(" 6 4 3 5 8 7 9",outContent.toString());
    }

    @Test
    public void inOrder확인(){
        bt.traverseInOrder(bt.root);
        assertEquals(" 3 4 5 6 7 8 9",outContent.toString());//출력 테스트
    }

    @Test
    public void postOrder확인(){
        bt.traversePostOrder(bt.root);
        assertEquals(" 3 5 4 7 9 8 6",outContent.toString());
    }

    @Test
    public void bfs확인(){
        bt.traverseLevelOrder();
        assertEquals(" 6 4 8 3 5 7 9",outContent.toString());
    }

}