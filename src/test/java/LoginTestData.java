public class LoginTestData {
    private final String testCase;
    private final String username;
    private final String password;
    private final String expectedMessage;
    private final String expectedGreeting;
    private final String cssClass;
    private final boolean isVisible;
    private final boolean isGreetingVisible;

    // Конструктор, геттеры и сеттеры
    public LoginTestData(String testCase, String username, String password, String expectedMessage,
                         String expectedGreeting, String cssClass, boolean isVisible, boolean isGreetingVisible) {
        this.testCase = testCase;
        this.username = username;
        this.password = password;
        this.expectedMessage = expectedMessage;
        this.expectedGreeting = expectedGreeting;
        this.cssClass = cssClass;
        this.isVisible = isVisible;
        this.isGreetingVisible = isGreetingVisible;
    }

    // Геттеры
    public String getTestCase() { return testCase; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getExpectedMessage() { return expectedMessage; }
    public String getExpectedGreeting() { return expectedGreeting; }
    public String getCssClass() { return cssClass; }
    public boolean isVisible() { return isVisible; }
    public boolean isGreetingVisible() { return isGreetingVisible; }
}
