深度优先：指的是二叉树的先序遍历，不管是递归完成还是非递归完成
广度优先：WidthTree.java中，广度遍历使用队列，先左再右

两种方式（树的套路+各自特征）：bst

树的套路：满二叉树（fulltree)，avl,bst,
cbt是只有自身特征：如果有右无左则不是cbt,否则当遇到叶子时候就不能再有孩子了

路线：首先广度遍历-》最大广度
    其次bst不用套路（pre)，cbt不用套路
    然后用套路解决
      avl(高度差<1) bst  fullt
      

总结：
      只有bst既有套路也有自己的方式
      对于自己的方式：
       1.bst采用中序遍历方式，碰到如果当前节点出现小于上一节点就return false
       2.cbt采用广度遍历队列方式：
             （1如果有右孩子无左孩子，return false  
              (2如果出现叶子节点后后面还有孩子return false
       
       对于套路方式：
        1.bst 使用min max isBst  左孩子max<当前value<右孩子min && isBstOnchildreb
        2.avl 使用isAvl Hi  当 isAvlOnChildre && Dis(leftHi,rightHi)<1
        3.fullt 使用nodes 和高度  当2^高度-1 == nodes成立即可
        
       
