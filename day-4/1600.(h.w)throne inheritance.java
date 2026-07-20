import java.util.*;

class ThroneInheritance {
    // Adjacency list to represent the family tree
    private Map<String, List<String>> familyTree;
    // Set to keep track of dead family members
    private Set<String> deadMembers;
    // The starting point of the family tree
    private String kingName;

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        this.familyTree = new HashMap<>();
        this.deadMembers = new HashSet<>();
        // Initialize the king in the tree
        this.familyTree.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        // Add the child to the parent's list of children
        this.familyTree.get(parentName).add(childName);
        // Initialize an empty list of children for the newborn
        this.familyTree.put(childName, new ArrayList<>());
    }
    
    public void death(String name) {
        // Mark the person as dead
        this.deadMembers.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        // Perform preorder traversal starting from the king
        dfs(kingName, order);
        return order;
    }

    private void dfs(String current, List<String> order) {
        // If the current person is alive, add them to the order
        if (!deadMembers.contains(current)) {
            order.add(current);
        }
        
        // Traverse all children in the order of their birth
        List<String> children = familyTree.get(current);
        if (children != null) {
            for (String child : children) {
                dfs(child, order);
            }
        }
    }
}
