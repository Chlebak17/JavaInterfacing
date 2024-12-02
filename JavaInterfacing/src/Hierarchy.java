import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Hierarchy extends Base {

    HashMap<String, HashMap<String, HashSet<String>>> loadData(String s){
        HashMap<String, HashMap<String, HashSet<String>>> bigMap = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("source\\Cities.txt"));
            //přidávání:
            String[] parts;
            for (String line :
                    lines) {
                parts = line.split(",");
                //kontinent
                if (!bigMap.containsKey(parts[2])) {
                    bigMap.put(parts[2], new HashMap<>());
                }

                //země kontinentu:
                if (!bigMap.get(parts[2]).containsKey(parts[1])) {
//                vezmi kontinent, vloz do nej, zemi a hashmapu mest
                    bigMap.get(parts[2]).put(parts[1], new HashSet<>());
                }

                bigMap.get(parts[2]).get(parts[1]).add(parts[0]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return bigMap;
    }
    public Hierarchy(){
        setLayout(new BorderLayout());
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("World");

        HashMap<String, HashMap<String, HashSet<String>>> bigMap = loadData("source\\Cities.txt");
        DefaultMutableTreeNode continentNode = null;
        for (String continent: bigMap.keySet()) {
            //uvnitr
            continentNode = new DefaultMutableTreeNode(continent);
            root.add(continentNode);
            for(String country : bigMap.get(continent).keySet()){
                DefaultMutableTreeNode countryNode = new DefaultMutableTreeNode(country);
                continentNode.add(countryNode);
                for (String city: bigMap.get(continent).get(country)){
                    DefaultMutableTreeNode cityNode = new DefaultMutableTreeNode(city);
                    countryNode.add(cityNode);
                };
            }


        }



        DefaultTreeModel model = new DefaultTreeModel(root);
        JTree tree = new JTree(model);
        JScrollPane treePane = new JScrollPane(tree);

//        DefaultMutableTreeNode example = new DefaultMutableTreeNode("example");

//        for (int i = 0; i < 5; i++) {
//            root.add(new DefaultMutableTreeNode("Ukazka " + i));
//        }
//        for (int i = 0; i < 5; i++) {
//            example.add(new DefaultMutableTreeNode("Test " + i));
//        }

        JTextArea textArea = new JTextArea();
        JScrollPane textPane = new JScrollPane(textArea);
        textPane.setPreferredSize(new Dimension(200,getHeight()));

//        System.out.println(root.toString());
        add(treePane,BorderLayout.CENTER);
        add(textPane,BorderLayout.EAST);
    }

    public static void main(String[] args) {
        new Hierarchy().setVisible(true);
    }
}
