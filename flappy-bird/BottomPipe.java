/**
 * 下方水管对象，用来阻止小鸟飞行
 */
public class BottomPipe extends Pipe{

    public BottomPipe(int player) {
        super(player);
        setImage("pipe" + player + "_up.png");
    }
}
