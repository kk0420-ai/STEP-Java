import java.util.*;

public class EmailAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> emails = new ArrayList<>();
        System.out.println("Enter emails (type 'end' to stop):");
        while (true) {
            String email = sc.nextLine();
            if (email.equalsIgnoreCase("end")) break;
            emails.add(email);
        }

        int valid = 0;
        Map<String, Integer> domainCount = new HashMap<>();
        int usernameLengthSum = 0;

        System.out.printf("%-30s %-10s %-15s %-10s %-10s %-10s\n", "Email", "Valid", "Username", "Domain", "Name", "Ext");
        for (String email : emails) {
            boolean isValid = validate(email);
            String username = "", domain = "", name = "", ext = "";

            if (isValid) {
                valid++;
                username = email.substring(0, email.indexOf("@"));
                domain = email.substring(email.indexOf("@") + 1);
                int dot = domain.lastIndexOf(".");
                name = domain.substring(0, dot);
                ext = domain.substring(dot + 1);

                domainCount.put(domain, domainCount.getOrDefault(domain, 0) + 1);
                usernameLengthSum += username.length();
            }

            System.out.printf("%-30s %-10s %-15s %-10s %-10s %-10s\n",
                    email, isValid ? "Yes" : "No", username, domain, name, ext);
        }

        String commonDomain = domainCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey).orElse("N/A");

        System.out.println("\nValid Emails: " + valid);
        System.out.println("Invalid Emails: " + (emails.size() - valid));
        System.out.println("Most Common Domain: " + commonDomain);
        System.out.println("Avg Username Length: " + (valid > 0 ? (usernameLengthSum / valid) : 0));
    }

    static boolean validate(String email) {
        int at = email.indexOf("@");
        int lastAt = email.lastIndexOf("@");
        if (at == -1 || at != lastAt) return false;
        int dot = email.indexOf(".", at);
        if (dot == -1 || at == 0 || dot == at + 1 || dot == email.length() - 1) return false;
        return true;
    }
}
