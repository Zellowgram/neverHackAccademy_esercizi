import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SecureCommandExecutor {
    public static void executeCommand(String userInput) {
       
    //Creo un array di stringhe specificando gli input inammissibili   
    String[] inputNonConsentibili = {"; rm -rf /", ";", "&", "|", "&&", "||", "pwd", "'", "touch", "echo"};
    boolean valido = true; //una variabile che funge da controllore
    //Il ciclo for each serve per scorrere nell'array e verificare che l'input non contenga nessun elemento specificato nell'array 
    for (String combinazione : inputNonConsentibili){
        //Ad ogni iterazione combinazione assume il valore di un elemento dell'array
        //Il metodo contains verifica che nel nostro imput non vi siano elementi dell'array
        if(userInput.contains(combinazione)){
            //il metodo replace cancella dall'input il comando nascosto per evitare qualsiasi tipo di compromissione
            String cancelCommands = serInput.replace(inputNonConsentibili, "");
            System.out.println("input non valido");
            valido = false;
            break;
        }
       }
       if(valido == false) break; // Se l'imput non è valido blocca l'esecuzione
        try {
            String command = "ping -c 4 " + userInput;
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            executeCommand(args[0]);
        } else {
            System.out.println("Usage: java InsecureCommandExecutor <IP>");
        }
    }
}