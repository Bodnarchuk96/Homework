package lessons26.example01;

public class AccessFilter implements Filter {

    @Override
    public boolean allowAccess(String url, UserType userType) {
        if (userType == UserType.ADMIN) {
            return true;
        } else if (userType == UserType.USER) {
            return url.startsWith("http://web-for-user");
        }
        return false;
    }
}