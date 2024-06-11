package lessons26.example01;

enum UserType {
    USER("Пользователь"),
    ADMIN("Администратор");

    private final String displayValue;

    UserType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
