package com.example.demo.realClasses;
public class Song {
     private String title;
     private int byteSize;
     private Album album;

     private Song(String title, int byteSize, Album album) {
          this.title = title;
          this.byteSize = byteSize;
          this.album = album;
          album.getSongs().add(this); // Add this song to the album
     }

     public static Song createSong(String title, int byteSize, Album album) {
          return new Song(title, byteSize, album); // Factory method
     }

     public String getTitle() { return title; }
     public Album getAlbum() { return album; }
     @Override
     public String toString() {
          return "Song{title='" + title + "', byteSize=" + byteSize + "}";
     }
}
