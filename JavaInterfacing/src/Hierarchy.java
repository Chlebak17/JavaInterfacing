import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class Hierarchy extends Base {
    public Hierarchy(){
        setLayout(new BorderLayout());

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("MainNode");
        DefaultTreeModel model = new DefaultTreeModel(root);
        JTree tree = new JTree(model);
        JScrollPane treePane = new JScrollPane(tree);

        DefaultMutableTreeNode example = new DefaultMutableTreeNode("example");
        root.add(example);

        for (int i = 0; i < 5; i++) {
            root.add(new DefaultMutableTreeNode("Ukazka " + i));
        }
        for (int i = 0; i < 5; i++) {
            example.add(new DefaultMutableTreeNode("Test " + i));
        }

        JTextArea textArea = new JTextArea();
        JScrollPane textPane = new JScrollPane(textArea);
        textPane.setPreferredSize(new Dimension(200,getHeight()));

        System.out.println(root.toString());
        add(treePane,BorderLayout.CENTER);
        add(textPane,BorderLayout.EAST);
    }

    public static void main(String[] args) {
        new Hierarchy().setVisible(true);
    }
}
