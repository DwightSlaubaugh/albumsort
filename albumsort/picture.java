/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package albumsort;


/**
 *
 * @author Dwight
 */
//the picture class
public class picture {
    public int albumid;
    private int id;
    private String title;
    private String url;
    private String thumb;
    
    //class initializer
    picture (int albumid, int id, String title, String url, String thumb){
        this.id = id;
        this.title = title;
        this.albumid = albumid;
        this.url = url;
        this.thumb = thumb;
    }
    //the formate we want our pictures to print
    public String toString(){
        return "[" + id + "]" + title;
    }
 

}