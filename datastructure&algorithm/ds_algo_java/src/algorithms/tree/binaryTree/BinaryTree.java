package algorithms.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    //BFS
    public void traverseLevelOrder(){
        if(root==null) return;
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()){
            Node node = nodes.poll();
            System.out.print(" "+node.value);
            if(node.left!=null) nodes.offer(node.left);
            if(node.right!=null) nodes.offer(node.right);
        }

    }
    //dfs 후위순회 - PostOrder
    public void traversePostOrder(Node node){
        if(node != null){
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" "+node.value);
        }
    }

    //dfs 전위순회 - preOrder
    public void traversePreOrder(Node node){
        if(node != null){
            System.out.print(" "+node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    //dfs 중위순회 -in order
    public void traverseInOrder(Node node){
        if(node != null){
            traverseInOrder(node.left);
            System.out.print(" "+node.value);
            traverseInOrder(node.right);
        }
    }
    //값 삭제
    public void delete(int value){
        root = deleteRecursive(root,value);
    }
    //값 삭제 도우미 함수
    private Node deleteRecursive(Node current, int value){
        if(current ==null){
            return null;
        }
        
        if(value == current.value){
            //삭제할 노드를 찾았다
            //삭제하는 코드가 여기 들어간다
            // a node has no children – this is the simplest case; we just need to replace this node with null in its parent node
            if(current.left==null && current.right==null){
                return null;
            }

            // a node has exactly one child – in the parent node, we replace this node with its only child.
            //하나의 자손만 있는 경우 해당 자손을 리턴한다
            if(current.right==null){
                return current.left;
            }
            if (current.left==null){
                return current.right;
            }

            // a node has two children – this is the most complex case because it requires a tree reorganization
            //둘의 자손이 있는 경우
            //삭제할 값보다 더 큰 노드로 들어가서 개중에 가장 작은 값을(왼쪽으로만 가면 계속 더 작은애 나옴) 찾는다
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;//삭제될 노드의 값을 삭제될 노드보다 큰 값중 가장 작은 값으로 설정
            current.right = deleteRecursive(current.right,smallestValue);//smallestValue에 해당하는 값 삭제된 서브노드 반환됨
            return current;//여기서 left설정은 왜 안해주나 헷갈렸었는데 생각해보니 left는 계속 달려있었음
        }
        //찾는 값이 현재 노드의 값보다 작으므로
        if(value<current.value){//왼쪽 자식 노드로 리커션
            current.left = deleteRecursive(current.left,value);
            return current;//밑에서 알아서 찾고 지우고 본체 리턴
        }
        //찾는 값이 현재 노드의 값보다 크다
        current.right = deleteRecursive(current.right,value);
        return current;//우측에서 알아서 찾고 지운다음 본체 리턴
        
    }
    //왼쪽으로 계속 내려가면서 최솟값 찾음 (root에서 왼쪽으로만 내려가면 값이 점점 작아진다)
    private int findSmallestValue(Node root){
        return root.left == null? root.value:findSmallestValue(root.left);
    }


    
    //값 탐색
    public boolean containsNode(int value){
        return containsNodeRecursive(root,value);
    }
    //값 탐색 도우미 함수
    private boolean containsNodeRecursive(Node current, int value){
        if(current==null) return false;

        if(value==current.value) return true;
        return (value<current.value)?
                containsNodeRecursive(current.left,value): //찾는값이 현재노드 값보다 작을 때
                containsNodeRecursive(current.right,value);//찾는값이 현재노드 값보다 클 때
    }


    //트리생성
    public BinaryTree createBinaryTree(){
        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        return bt;
    }
    //트리에 값 추가
    public void add(int value){
        root = addRecursive(root, value);//뿌리노드를 리턴한다. 즉 이진 트리를 리턴한다
    }
    //오름차순 정렬을 지키면서 들어가도록 함
    private Node addRecursive(Node current, int value){
        if(current==null){
            return new Node(value);
        }
        //넣을값이 현재 노드 값보다 작으면
        if(value < current.value){
            current.left = addRecursive(current.left,value);
        }else if(value>current.value){
            current.right = addRecursive(current.right,value);
        }else{
            return current;
        }
        return current;
    }


}
