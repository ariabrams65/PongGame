
package GameLogic;


public class ScoreManager {
    
    int leftScore;
    int rightScore;
    
    public ScoreManager() {
        
    }
    
    public void addLeft() {
        this.leftScore++;
    }
    
    public void addRight() {
        this.rightScore++;
    }
    
    public int getLeft() {
        return this.leftScore;
    }
    
    public int getRight() {
        return this.rightScore;
    }
}
