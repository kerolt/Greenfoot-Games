import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.*;
/**
 * �����࣬���������ټ�
 */
public class PianoWorld extends World{
    
    // �׼�
    private String[] whiteKeys = { 
        "a", "s", "d", "f", "g", "h", "j",
        "k", "l", ";", "'", "z", "x", "c",
        "v", "b", "n", "m", ",", ".", "/",
    };
    
    // �׼�����
    private String[] whiteNotes = {
        "C3", "D3", "E3", "F3", "G3", "A3", "B3", 
        //"4c", "4d", "4e", "4f", "4g" 
        "C4", "D4", "E4", "F4", "G4", "A4", "B4",  
        "C5", "D5", "E5", "F5", "G5", "A5", "B5", 
    };
    
    // �ڼ�
    private String[] blackKeys = {
        "q", "w", "", "e", "r", "t", "",  
        "y", "u", "", "i", "o", "p", "",  
        "[", "]", "", "left", "down", "right", "",  
    };
    
    // �ڼ�����
    private String[] blackNotes = {
        "Cs3", "Ds3", "", "Fs3", "Gs3", "As3", "",
        "Cs4", "Ds4", "", "Fs4", "Gs4", "As4", "",
        "Cs5", "Ds5", "", "Fs5", "Gs5", "As5", "",
    };
    
    // ÿ������Ӧ�İ���
    public Map<String, Key> keyMap = new HashMap<String, Key>();
        
    public PianoWorld() {
        super(1000, 600, 1);
        setBackground("bg" + ImageBoard.imgIdx + ".jpg");
        addObject(new MusicScore(), 950, 50);
        addObject(new BackButton(), 70, 45);
        makeKeys();        //����makeKeys()��������Ϸ���������ϻ������е��ټ�
    }
    
    private void makeKeys() {
        int i = 0;
        
        // ���ư�ɫ�ټ�
        while (i < whiteKeys.length) {
            Key key = new Key(whiteKeys[i], "music/" + whiteNotes[i]+".wav", "white-key.png", "white-key-down.png");
            keyMap.put(whiteNotes[i], key);
            addObject(key, 54 + (i*45), 490);  //ÿ��63����������,���λ���һ����ɫ�ټ�
            i = i + 1;
        }
        
        // ���ƺ�ɫ�ټ�
        for(i = 0; i < blackKeys.length; i++) {
            if(!blackKeys[i].equals("")) {
                Key key = new Key(blackKeys[i], "music/" + blackNotes[i]+".wav", "black-key.png", "black-key-down.png");
                keyMap.put(blackNotes[i], key);
                addObject(key, 74 + (i*45), 461);
            }
        }
    }
}
