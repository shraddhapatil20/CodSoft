//package codsoft;
import java.io.*;
import java.util.*;

/**
 *
 * @author Saurabh
 */
public class WordCounter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text or provide a file to count words: ");
        String input = scanner.nextLine();

        String content="";
        try{
            if(input.endsWith(".txt")){
                content = readFromFile(input);
            }else{
                content = input;

            }
        }catch(IOException e){
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
            return;
        }

        String[] words = content.split("[\\s.,;!?]+");
        int wordCount=words.length;

        System.out.println("Total words :"+wordCount);

    }
    private static String readFromFile(String filePath) throws IOException{
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;


        while((line=reader.readLine())!=null){
            content.append(line).append(" ");
        }
        reader.close();
        return content.toString();
    }
}



/*  Output be like

       Enter a text or provide a file to count words: input.txt
	   Total words :12
Press any key to continue . . .

        Enter a text or provide a file to count words: my name is shraddha anant patil
		Total words :6
Press any key to continue . . .

*/