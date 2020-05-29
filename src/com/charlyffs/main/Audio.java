package com.charlyffs.main;

import javafx.scene.media.AudioClip;

import java.net.URL;
import java.util.ArrayList;

public class Audio {
    
    private static ArrayList<AudioClip> queue = new ArrayList<>();
    
    public static void playFile(String URL) {
        stopAll();
        URL file = Audio.class.getResource(URL);
        AudioClip audioClip = new AudioClip(file.toString());
        audioClip.setVolume(.011);
        queue.add(audioClip);
        queue.get(queue.size() - 1).play();
    }
    
    public static void playAttack() {
        URL file = Audio.class.getResource("/Audio/Tackle.mp3");
        queue.add(new AudioClip(file.toString()));
        queue.get(queue.size() - 1).play();
    }
    
    public static void stopAll() {
        for (AudioClip audioClip : queue) {
            audioClip.stop();
        }
        queue.clear();
    }
    
}
