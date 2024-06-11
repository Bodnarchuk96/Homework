package lessons26.example01;

public class Main {
    public static void main(String[] args) {
        Human admin = new Human("Volodymyr", 30, UserType.ADMIN);
        Human user = new Human("Anastasiia", 29, UserType.USER);

        Filter filter = new AccessFilter();

        String[] urls = {
                "http://web-for-user.com",
                "http://web-for-user.site",
                "http://admin-only.com",
                "http://example.com"
        };

        for (String url : urls) {
            System.out.println("URL: " + url);
            System.out.println("Admin access: " + filter.allowAccess(url, admin.getUserType()));
            System.out.println("User access: " + filter.allowAccess(url, user.getUserType()));
            System.out.println();
        }
    }
}