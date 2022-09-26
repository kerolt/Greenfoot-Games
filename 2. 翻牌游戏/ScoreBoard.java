import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor {
    
    private Scanner sc;
    private List<int[]> records;
    private int count;
    private int time;
    private static final Color backgroundColor = Color.BLACK;//排行榜颜色背景为粉色
    private static final Color transparent = new Color(255,255,255,0);//设置分数背景为透明

    public ScoreBoard() {
        this.count = Counter.count;
        this.time = (int) Time.playTime;
        readFile();
        addRecord();
        sortRecord();
        showRecord();
        writeToFile();
    }
    
    private void showRecord() {
        List<GreenfootImage> lines = new ArrayList<GreenfootImage>();
        ArrayList<Integer> timeList = new ArrayList<Integer>();
        lines.add(new GreenfootImage("游戏结束",48,Color.WHITE,transparent));
        for(int i = 0; i < this.records.size(); i++)
        {
            if (i == 3) break;
            int step = (this.records.get(i))[0];
            int time = (this.records.get(i))[1];
            String text = "第" + (i+1) + "名:" + time + "秒" + step +"步";
            lines.add(new GreenfootImage(text,48,Color.WHITE,transparent));
        }
        int width = 0;
        int height = 0;
        //根据现实的内容设置排行榜的宽和高
        for(GreenfootImage line :lines)
        {
            height += line.getHeight();
            if(width < line.getWidth())
            {
                width = line.getWidth();
            }
        }

        //创建排行榜图片
        GreenfootImage image = new GreenfootImage(width + 20,height + 20);
        image.setColor(backgroundColor);
        image.fill();
        //将各个显示内容的图像绘制在排行榜图像上
        for(int i = 0,y = 10;i < lines.size(); i++)
        {
            GreenfootImage line = lines.get(i);
            image.drawImage(line,(image.getWidth() - line.getWidth())/2 , y);
            y += line.getHeight();
        }
        setImage(image);//设置排行榜图像
    }
    
    /**
     * 添加记录
     */
    private void addRecord() {
        int[] newRecord = {this.count, this.time};
        this.records.add(newRecord);
    }
    
    /**
     * 对记录进行排序
     */
    private void sortRecord() {
        this.records.sort((r1, r2) -> {
            if (r1[0] != r2[0]) {
                return r1[0] - r2[0];
            }
            return r1[1] - r2[1];
        });
    }
    
    /**
     * 将更新后的记录写入文件，以便实现数据的持久化
     */
    private void writeToFile(){
        try(BufferedWriter bf = new BufferedWriter(new FileWriter("D:\\data.txt"))) {
            // 如果记录数超过三条只需要前三条
            int size = this.records.size() > 3 ? 3 : this.records.size(); 
            // 只取前三条
            for (int i = 0; i < size; i++) {
                bf.write((this.records.get(i))[0] + " " + (this.records.get(i))[1]);
                bf.write("\n");
            }
        } catch (IOException e) {  
            e.printStackTrace();    
        }
    }
    
    /**
     * 打开存放有关记录的文件，如果不存在，则会自动创建；并读取文件内容
     */
    private void readFile() {
        this.records = new ArrayList<>();
        File data = new File("D:\\data.txt");
        // 不存在则会自动创建
        if (!data.exists()) { 
            try {    
                data.createNewFile();    
            } catch (IOException e) {   
                e.printStackTrace();    
            }
        }
        
        FileWriter fileWriter = null;
        // 读取文件中的数据
        try {
            sc = new Scanner(new FileReader("D:\\data.txt"));
            // 文件中一行数据为一条记录
            while (sc.hasNextLine()) {
                String[] str = sc.nextLine().split(" ");
                int[] row = new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])};
                this.records.add(row);
            }

        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            sc.close(); // 保证无论如何都会关闭文件
        }
    }
}
