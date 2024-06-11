package lessons26.example01;

public interface Filter {
    boolean allowAccess(String url, UserType userType);
}