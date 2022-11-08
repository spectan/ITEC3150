/**
 * AbstractTree is a list of abstract methods for our binary tree.
 * @author - Dr. Johnson
 * @modified by - Samuel Mckinney
 */

public abstract class AbstractTree<E> implements Tree<E> {
  @Override /** Inorder traversal from the root*/
  public void inorder() {
  }

  @Override /** Reverse order traversal from the root*/
  public void reverseOrder() {
  }

  @Override /** Postorder traversal from the root */
  public void postorder() {
  }

  @Override /** Preorder traversal from the root */
  public void preorder() {
  }

  @Override /** Return true if the tree is empty */
  public boolean isEmpty() {
    return getSize() == 0;
  }
}
