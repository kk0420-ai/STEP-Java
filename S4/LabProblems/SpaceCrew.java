import java.util.*;

enum CrewRank {
    CADET(1), OFFICER(2), COMMANDER(3), CAPTAIN(4), ADMIRAL(5);
    private final int level;
    CrewRank(int level) { this.level = level; }
    public int getLevel() { return level; }
}

class SpaceCrew {
    final String crewId;
    final String homeplanet;
    final CrewRank initialRank;
    String currentRank;
    int skillLevel, missionCount, spaceHours;
    static final String STATION_NAME = "Stellar Odyssey";
    static final int MAX_CREW_CAPACITY = 50;

    public SpaceCrew(String name) { this(name, "Earth", CrewRank.CADET, 0, 0, 0); }
    public SpaceCrew(String name, String home, CrewRank rank) { this(name, home, rank, 0, 0, 0); }
    public SpaceCrew(String name, String home, CrewRank rank, int missions, int skills) { this(name, home, rank, missions, skills, missions * 50); }
    public SpaceCrew(String name, String home, CrewRank rank, int missions, int skills, int hours) {
        this.crewId = UUID.randomUUID().toString();
        this.homeplanet = home;
        this.initialRank = rank;
        this.currentRank = rank.name();
        this.missionCount = missions;
        this.skillLevel = skills;
        this.spaceHours = hours;
    }

    public final String getCrewIdentification() { return crewId + " from " + homeplanet; }
    public final boolean canBePromoted() { return skillLevel > 50 && missionCount > 5; }
    public final int calculateSpaceExperience() { return missionCount * 10 + spaceHours / 100; }

    public void display() {
        System.out.println(currentRank + " [" + getCrewIdentification() + "] Skills:" + skillLevel + " Missions:" + missionCount + " Exp:" + calculateSpaceExperience());
    }

    public static void main(String[] args) {
        SpaceCrew c1 = new SpaceCrew("Alice");
        SpaceCrew c2 = new SpaceCrew("Bob", "Mars", CrewRank.OFFICER);
        SpaceCrew c3 = new SpaceCrew("Eve", "Venus", CrewRank.COMMANDER, 10, 80);
        c1.display(); c2.display(); c3.display();
        System.out.println("Promotable? " + c3.canBePromoted());
    }
}
