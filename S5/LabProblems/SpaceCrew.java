import java.util.Objects;

final class SecurityClearance {
    private final String clearanceId;
    private final String level;
    private final String[] authorizedSections;
    private final long expirationDate;

    public SecurityClearance(String clearanceId, String level, String[] sections, long expirationDate) {
        if (clearanceId == null || level == null || sections == null || expirationDate <= 0)
            throw new IllegalArgumentException("Invalid clearance data");

        this.clearanceId = clearanceId;
        this.level = level;
        this.authorizedSections = sections.clone();
        this.expirationDate = expirationDate;
    }

    public final boolean canAccess(String section) {
        for (String s : authorizedSections) {
            if (s.equals(section)) return true;
        }
        return false;
    }

    public final boolean isExpired() {
        return System.currentTimeMillis() > expirationDate;
    }

    public final int getAccessHash() {
        return clearanceId.hashCode() ^ level.hashCode();
    }

    public String getClearanceId() { return clearanceId; }
    public String getLevel() { return level; }
    public String[] getAuthorizedSections() { return authorizedSections.clone(); }
    public long getExpirationDate() { return expirationDate; }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SecurityClearance)) return false;
        SecurityClearance other = (SecurityClearance) obj;
        return clearanceId.equals(other.clearanceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clearanceId, level);
    }

    @Override
    public String toString() {
        return "Clearance[" + level + "]";
    }
}

final class CrewRank {
    private final String rankName;
    private final int level;
    private final String[] permissions;

    private CrewRank(String rankName, int level, String[] permissions) {
        this.rankName = rankName;
        this.level = level;
        this.permissions = permissions.clone();
    }

    public static CrewRank createCadet() {
        return new CrewRank("Cadet", 1, new String[]{"BAY_A"});
    }

    public static CrewRank createOfficer() {
        return new CrewRank("Officer", 2, new String[]{"BAY_A", "MED"});
    }

    public static CrewRank createCommander() {
        return new CrewRank("Commander", 3, new String[]{"BAY_A", "LAB", "BRIDGE"});
    }

    public static CrewRank createCaptain() {
        return new CrewRank("Captain", 4, new String[]{"ALL"});
    }

    public static CrewRank createAdmiral() {
        return new CrewRank("Admiral", 5, new String[]{"ALL"});
    }

    public String getRankName() { return rankName; }
    public int getLevel() { return level; }
    public String[] getPermissions() { return permissions.clone(); }

    @Override
    public String toString() {
        return rankName + " (Level " + level + ")";
    }
}

public class SpaceCrew {
    private final String crewId;
    private final String homeplanet;
    private final SecurityClearance clearance;
    private final CrewRank initialRank;

    private CrewRank currentRank;
    private int missionCount;
    private double spaceHours;

    public static final String STATION_NAME = "Stellar Odyssey";
    public static final int MAX_CREW_CAPACITY = 50;

    public SpaceCrew(String crewId, String homeplanet, SecurityClearance clearance, CrewRank rank) {
        this.crewId = crewId;
        this.homeplanet = homeplanet;
        this.clearance = clearance;
        this.initialRank = rank;
        this.currentRank = rank;
        this.missionCount = 0;
        this.spaceHours = 0;
    }

    public final String getCrewIdentification() {
        return crewId + "@" + STATION_NAME;
    }

    public final boolean canBePromoted() {
        return missionCount > 5 && !clearance.isExpired();
    }

    public final int calculateSecurityRating() {
        return clearance.getAccessHash() + currentRank.getLevel();
    }

    public void setMissionCount(int count) {
        if (count < 0) throw new IllegalArgumentException("Invalid mission count");
        this.missionCount = count;
    }

    public void setSpaceHours(double hours) {
        if (hours < 0) throw new IllegalArgumentException("Invalid space hours");
        this.spaceHours = hours;
    }

    public CrewRank getCurrentRank() {
        return currentRank;
    }

    public void promote(CrewRank newRank) {
        this.currentRank = newRank;
    }

    public String getHomeplanet() { return homeplanet; }
    public CrewRank getInitialRank() { return initialRank; }
    public SecurityClearance getClearance() { return clearance; }

    @Override
    public String toString() {
        return "SpaceCrew{" + crewId + ", rank=" + currentRank + ", planet=" + homeplanet + "}";
    }

    public static void main(String[] args) {
        String[] sections = {"BAY_A", "MED", "LAB"};
        SecurityClearance clearance = new SecurityClearance("CL-1001", "Level-2", sections, System.currentTimeMillis() + 1000000);
        CrewRank rank = CrewRank.createOfficer();

        SpaceCrew crew = new SpaceCrew("CR-01", "Earth", clearance, rank);
        crew.setMissionCount(6);
        crew.setSpaceHours(123.5);

        System.out.println("Crew Info: " + crew);
        System.out.println("ID: " + crew.getCrewIdentification());
        System.out.println("Can access LAB: " + clearance.canAccess("LAB"));
        System.out.println("Can be promoted: " + crew.canBePromoted());
        System.out.println("Security Rating: " + crew.calculateSecurityRating());
    }
}
