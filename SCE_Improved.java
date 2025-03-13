import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class SCE_Improved {

    // Whitelist di caratteri validi per un indirizzo IP
    private static final Pattern IP_PATTERN = Pattern.compile("^[0-9.]+$");

    // Whitelist di indirizzi IP validi (esempio)
    private static final String[] ALLOWED_IPS = {"192.168.1.1", "8.8.8.8", "127.0.0.1"};

    public static void executeCommand(String userInput) {
        System.out.println("Esecuzione del programma con input: " + userInput);
        System.out.println("Validazione dell'input...");

        // Validazione dell'input
        if (!isValidInput(userInput)) {
            System.out.println("❌ Errore: L'input non è valido.");
            System.out.println("Motivo: L'indirizzo IP contiene caratteri non consentiti o non è nella whitelist.");
            return;
        }

        System.out.println("✅ Input valido. Esecuzione del comando ping...");

        try {
            // Costruzione del comando in modo sicuro (compatibile con Windows)
            String[] command = {"ping", "-n", "4", userInput};
            Process process = new ProcessBuilder(command).start();

            // Lettura dell'output del comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            System.out.println("\n=== Risultato del comando ping ===");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("=== Fine del risultato ===\n");

            // Verifica dello stato di uscita del comando
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("✅ Comando eseguito con successo.");
            } else {
                System.out.println("⚠️ Attenzione: Il comando ha restituito un codice di errore: " + exitCode);
            }
        } catch (Exception e) {
            System.out.println("❌ Errore durante l'esecuzione del comando:");
            e.printStackTrace();
        }
    }

    // Funzione per validare l'input
    private static boolean isValidInput(String userInput) {
        // Verifica che l'input contenga solo caratteri validi
        if (!IP_PATTERN.matcher(userInput).matches()) {
            return false;
        }

        // Verifica che l'input sia nella whitelist
        for (String allowedIp : ALLOWED_IPS) {
            if (allowedIp.equals(userInput)) {
                return true;
            }
        }

        return false; // Se non è nella whitelist, ritorna false
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            executeCommand(args[0]);
        } else {
            System.out.println("❌ Errore: Nessun input fornito.");
            System.out.println("Usage: java SecureCommandExecutor <IP>");
            System.out.println("Esempio: java SecureCommandExecutor 192.168.1.1");
        }
    }
}