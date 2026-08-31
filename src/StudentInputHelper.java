import java.util.Scanner;

public class StudentInputHelper {
    public static boolean validateAgeAndClass (
            Scanner scanner,
            int age,
            int std
    ){
        if(StudentRules.isAgeClassValid(age, std)) {
            return true;
        }

        int expectedAge = StudentRules.getExpectedAge(std);

        System.out.printf(
                "The Age and Class combination don't really add up. " +
                        "Expected Age %d-%d-%d for Class %d\n",
                expectedAge - 1,
                expectedAge,
                expectedAge + 1,
                std
        );

        System.out.print("Treat this as an exception? (Y / N): ");

        return InputValidator.getValidYOrN(scanner);
    }
}
