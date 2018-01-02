/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package albumsortquick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Dwight
 */
public class Albumsortquick {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
                 
        //URL of the website getting the picture information from
        URL url = new URL("https://jsonplaceholder.typicode.com/photos");
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        //our parsing string
        String line = null;
        //counts to help print correct information
        int album = 0;
        int count = 0;
        //this while will read the lines for us
        while ((line = br.readLine()) != null) {
             //first iff checks if album is on the correct number
             //the Integer.parseInt is getting just the albumid int from the line
             if(line.contains("albumId") && album != Integer.parseInt(line.replaceAll("[\\D]", "")))
                 album ++;
            //this checks if there is a new album starting
            if ( count != album){
                System.out.println(">photo-album " + album +"\n");
                count ++;
            }
            //this is reading all the pertinent information we wan
            if(line.contains("albumId") && album == Integer.parseInt(line.replaceAll("[\\D]", ""))){
                //moving to the next line to get the picture id
                line = br.readLine();
                int id = Integer.parseInt(line.replaceAll("[\\D]", ""));
                //moving to the next line to get picture title
                line = br.readLine();
                String title = line.replace("\"", "");
                //getting the title
                title = title.replace("title:", "");
                title = title.replace(",", "");
                //printing out the iformatino we want
                System.out.println("[" + id + "]" + title);
                
            }
        }
    }
}
