public class Levels implements Entity {
    private String title;
    private String description;
    private boolean unlocked;
    private boolean completed;

    public Levels(String title, String description) {
        this.title = title;
        this.description = description;
        this.unlocked = false; // Level starts locked
        this.completed = false; // Level starts incomplete
    }

    @Override
    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Unlocked: " + (unlocked ? "Yes" : "No"));
        System.out.println("Completed: " + (completed ? "Yes" : "No"));
    }

    public void unlock() {
        unlocked = true;
        System.out.println("Level " + title + " is now unlocked!");
    }

    public void complete() {
        completed = true;
        System.out.println("Level " + title + " is completed!");
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
