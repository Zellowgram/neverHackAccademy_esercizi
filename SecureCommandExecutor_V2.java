import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class SecureCommandExecutor_V2 {

    // Whitelist per indirizzi IP (esempio: IPv4)
    private static final Pattern IP_PATTERN = Pattern.compile(
        "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$"
    );

    public static void executeCommand(String userInput) {
        try {
            // Validazione dell'input
            if (!isValidIP(userInput)) {
                System.out.println("Input non valido. Inserire un indirizzo IP valido.");
                return;
            }

            // Costruzione del comando in modo sicuro
            String[] command = {"ping", "-c", "4", userInput};
            Process process = new ProcessBuilder(command).start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo per validare l'indirizzo IP
    private static boolean isValidIP(String ip) {
        return IP_PATTERN.matcher(ip).matches();
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            executeCommand(args[0]);
        } else {
            System.out.println("Usage: java SecureCommandExecutor <IP>");
        }
    }
}