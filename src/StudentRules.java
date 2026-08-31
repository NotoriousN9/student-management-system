public class StudentRules {
    public static boolean isAgeClassValid(int age, int std) {
        int expectedAge = std + 5;

        return age >= expectedAge - 1 && age <= expectedAge + 1;
    }

    public static int getExpectedAge(int std) {
        return std + 5;
    }
}
