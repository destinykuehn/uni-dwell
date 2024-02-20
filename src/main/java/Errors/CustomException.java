package Errors;

public class CustomException extends Exception {

    public CustomException(int errorCode) {
        super(generateErrorMessage(errorCode));
    }

    private static String generateErrorMessage(int errorCode) {
        String message;
        switch (errorCode) {
            case 0:
                message = String.format(
                        "Error %d: LotTooSmall. " +
                                "The lot size cannot be smaller than the aggregate room sizes.",
                        errorCode);
                return message;
            case 1:
                message = "";
                return message;
            default:
                message = "Unknown error code";
                return message;
        }
    }
}
