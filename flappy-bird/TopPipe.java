/**
 * 上方水管对象，用来阻止小鸟飞行
 */
public class TopPipe extends Pipe{  
    
    public TopPipe(int player) {
        super(player);
        setImage("pipe" + player + "_down.png");
    }
}
