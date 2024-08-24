package CODSOFT;
import java.util.*;

public class project3 {

    // Define the Item class
    static class Item {
        private int id;
        private String name;
        private List<String> tags;

        public Item(int id, String name, List<String> tags) {
            this.id = id;
            this.name = name;
            this.tags = tags;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<String> getTags() {
            return tags;
        }

        @Override
        public String toString() {
            return name + " (ID: " + id + ")";
        }
    }

    //  User class
    static class User {
        private int id;
        private List<Item> likedItems;

        public User(int id) {
            this.id = id;
            this.likedItems = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public List<Item> getLikedItems() {
            return likedItems;
        }

        public void addLikedItem(Item item) {
            likedItems.add(item);
        }
    }

    // RecommendationSystem class
    static class RecommendationSystem {

        private List<Item> allItems;

        public RecommendationSystem(List<Item> allItems) {
            this.allItems = allItems;
        }

        public List<Item> recommendItems(User user) {
            Set<String> likedTags = new HashSet<>();
            for (Item item : user.getLikedItems()) {
                likedTags.addAll(item.getTags());
            }

            Map<Item, Integer> itemScores = new HashMap<>();
            for (Item item : allItems) {
                if (!user.getLikedItems().contains(item)) {
                    int score = 0;
                    for (String tag : item.getTags()) {
                        if (likedTags.contains(tag)) {
                            score++;
                        }
                    }
                    itemScores.put(item, score);
                }
            }

            return itemScores.entrySet().stream()
                             .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                             .map(Map.Entry::getKey)
                             .toList();
        }
    }

    // class to test the recommendation system
    public static void main(String[] args) {
        // Create some items
        Item item1 = new Item(1, "Item 1", Arrays.asList("tag1", "tag2"));
        Item item2 = new Item(2, "Item 2", Arrays.asList("tag2", "tag3"));
        Item item3 = new Item(3, "Item 3", Arrays.asList("tag1", "tag3"));
        Item item4 = new Item(4, "Item 4", Arrays.asList("tag4", "tag5"));
        Item item5 = new Item(5, "Item 5", Arrays.asList("tag1", "tag6"));

        List<Item> allItems = Arrays.asList(item1, item2, item3, item4, item5);

        // Create a user
        User user = new User(1);
        user.addLikedItem(item1);
        user.addLikedItem(item2);

        // Create the recommendation system
        RecommendationSystem recommendationSystem = new RecommendationSystem(allItems);

        // Get recommendations
        List<Item> recommendedItems = recommendationSystem.recommendItems(user);

        // Print recommendations
        System.out.println("Recommended items for user " + user.getId() + ":");
        for (Item item : recommendedItems) {
            System.out.println(item);
        }
    }
}