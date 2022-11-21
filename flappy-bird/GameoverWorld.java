import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.*;
/**
 * 游戏结束类
 */
public class GameoverWorld extends World {
    
    private static List<Integer> scoreList = null;
    
    public GameoverWorld() {    
        super(1200, 700, 1);
        
        if (this.scoreList != null) {
            this.scoreList.clear();
        }
        
        addObject(new GameOver(), getWidth() / 2, 170);
        // 单人模式下才有排行榜
        if (Sky.parttern == 0) {
            writeScoreToFile();
            addObject(new ScoreBoard(0), getWidth() / 2 - 350, 400);
            addObject(new ScoreBoard(1), getWidth() / 2, 400);
            addObject(new ScoreBoard(2), getWidth() / 2 + 350, 400);
            drawNumber(0, getWidth() / 2 - 350 + 70, 400);
            drawNumber(1, getWidth() / 2 + 70, 400);
            drawNumber(2, getWidth() / 2 + 350 + 70, 400);
            showText("您的分数： " + Score.score, getWidth() / 2, 250);
        } else {
            showText("恭喜玩家" + (Sky.winner + 1) + "获取胜利！", getWidth() / 2, getHeight() / 2);
        }
    }
    
    public void drawNumber(int idx, int w, int h) {
        if (idx < this.scoreList.size()) {
            int num = this.scoreList.get(idx);
            // 两位数要进行一下处理
            if (num >= 10) {
                addObject(new ScoreNumber(num / 10), w - 11, h);
                addObject(new ScoreNumber(num % 10), w + 11, h);
            } else {
                addObject(new ScoreNumber(num), w, h);
            }
        }
    }
    
    public void writeScoreToFile() {
        File data = new File("D:\\data.txt");
        this.scoreList = new ArrayList<>();
        
        // 不存在则会自动创建
        if (!data.exists()) { 
            try {    
                data.createNewFile();    
            } catch (IOException e) {   
                e.printStackTrace();    
            }
        }
        
        // 读取文件中的内容        
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\data.txt"))) {
            String line = br.readLine();
            if (line != null) {
                String[] str = line.split(" ");
                for (String s : str) {
                    this.scoreList.add(Integer.parseInt(s));
                }
            }
        } catch (IOException e) {  
            e.printStackTrace();    
        }
        
        // 排序后选取按从大到小的顺序存储前三条
        this.scoreList.add(Score.score);
        this.scoreList.sort((a, b) -> b - a);
        try(BufferedWriter bf = new BufferedWriter(new FileWriter("D:\\data.txt"))) {
            // 如果记录数超过三条只需要前三条
            int size = this.scoreList.size() > 3 ? 3 : this.scoreList.size(); 
            // 只取前三条
            for (int i = 0; i < size; i++) {
                bf.write(this.scoreList.get(i) + " ");
            }
        } catch (IOException e) {  
            e.printStackTrace();    
        }
    }
}
