/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package albumsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
/**
 *
 * @author Dwight
 */





public class AlbumSort {
    
    //three helper functions to get clean data.
     static String removeTitle(String s){
        String title = s.replace("\"", "");
        title = title.replace("title:", "");
        title = title.replace(",", "");
        return title;
    }
    static String removeUrl(String s){
        String url = s.replace("\"", "");
        url = url.replace("url:", "");
        url = url.replace(",", "");
        return url;
    }
    static String removeThumb(String s){
        String thumb = s.replace("\"", "");
        thumb = thumb.replace("thumbnailUrl:", "");
        thumb = thumb.replace(",", "");
        return thumb;
    }
    public static void main(String[] args) throws IOException {
        ArrayList<picture> album = new ArrayList<picture>();
        //URL of the website getting the picture information from
        URL url = new URL("https://jsonplaceholder.typicode.com/photos");
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        
        //this while loop reads all of the data and puts it into the picture class
        while ((line = br.readLine()) != null) {
             if(line.contains("albumId")){
                 //parse the first line for albumid
                 int albumid = Integer.parseInt(line.replaceAll("[\\D]", ""));
                 line = br.readLine();
                 //picture id
                 int id = Integer.parseInt(line.replaceAll("[\\D]", ""));
                 line = br.readLine();
                 //picture title
                 String title = removeTitle(line);
                 line = br.readLine();
                 //picture url
                 String Url = removeUrl(line);
                 line = br.readLine();
                 //picture thumbnail
                 String thumb = removeThumb(line);
                 //create the pictre
                 picture p = new picture(albumid, id, title, Url, thumb);
                 //add it to the album
                 album.add(p);
             }
        }
        //this loop will print out the pictures id and titles
        int print = 0;
        int count = album.size();
        for(int i = 0; i < count; i++){
                picture p = album.get(i);
                if(p.albumid == print){
                    System.out.println(p);
            }   
                //this else prints out which album it belongs too
                else{
                    print++;
                    System.out.println(">photo-album " + print +"\n");
                    System.out.println(p);
                }
            
	}
    }
}    
    

