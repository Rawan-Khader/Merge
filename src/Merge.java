import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Merge {


	 public static void main(String[] args) {
	        try {
	            mergeSegments();
	        } catch (FileNotFoundException ex) {
	            System.err.println("Err");
	        } catch (URISyntaxException | IOException ex) {
	            Logger.getLogger(Merge.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

        public static void mergeSegments() throws FileNotFoundException, URISyntaxException, IOException {

    	File file1 = new File("C:/Users/Rawan Khader/Desktop/f1/segments");
    	File outF = new File("C:/Users/Rawan Khader/Desktop/f1/assembled");
        FileOutputStream fos;

        FileInputStream fis;

        byte[] fileBytes;

        int bytesRead = 0;

        ArrayList<File> list = new ArrayList<File>();

        if(file1!=null && file1.exists()){
		        File[] listOfFiles = file1.listFiles();

		        if(listOfFiles!=null){

		            for (int i = 0; i < listOfFiles.length; i++) {
		                if (listOfFiles[i].isFile()) {
               list.add(listOfFiles[i]);
               System.out.println("");
		                }}}}

        try {

            fos = new FileOutputStream(outF,true);

            for (File file : list) {
             fis = new FileInputStream(file);

                fileBytes = new byte[(int) file.length()];

                bytesRead = fis.read(fileBytes, 0,(int)  file.length());

                assert(bytesRead == fileBytes.length);

                assert(bytesRead == (int) file.length());


                fos.write(fileBytes);

                fos.flush();

                fileBytes = null;

                fis.close();

                fis = null;

            }
         fos.close();

            fos = null;

        }catch (Exception exception){

            exception.printStackTrace();

        }

    }
}
