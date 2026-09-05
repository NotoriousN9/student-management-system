//Rather than roaming around to find rules it is stored here for Convenience like if we wanna change something like age we do it here

public class StudentRules {
    public static boolean isAgeClassValid(int age, int std) {
        int expectedAge = std + 5;

        return age >= expectedAge - 1 && age <= expectedAge + 1;
    }

    public static boolean isValidStudentName(String studentName) {
        return studentName != null && !studentName.isBlank() && studentName.matches("[a-zA-Z ]+");
    }

    public static int getExpectedAge(int std) {
        return std + 5;
    }

    public static boolean isValidStudentId(int studentId) {
        return studentId >= 1000 && studentId <= 9999;
    }

    public static boolean isValidStudentAge(int studentAge) {
        return studentAge >= 5 && studentAge <= 20;
    }

    public static boolean isValidStudentClass(int studentStd) {
        return studentStd >= 1 && studentStd <= 12;
    }
}
