import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;


public class Question extends Actor {

    private String[] text;
    private List<Answer> answers;
    private Explain explanation;
    
    /**
     * Create a new question.
     */
    public Question(String question, List<Answer> answers) {
        text = QuizWorld.wordWrap(question);
        this.answers = answers;
    }
    
    /**
     * Set the explanation for this question.
     */
    public void setExplanation(String explanation) {
        this.explanation = new Explain(explanation);
    }
    
    /**
     * Get the explanation for this question.
     */
    public Explain getExplanation() {
        return explanation;
    }
    
    /**
     * Determine whether this question has an explanation.
     */
    public boolean hasExplanation() {
        return explanation != null;
    }
    
    /**
     * Draw when added to the world.
     */
    public void addedToWorld(World world) {
        GreenfootImage image = new GreenfootImage(500, 100);
        image.setFont(new Font("SansSerif", Font.BOLD, 16));

        for(int i=0 ; i<text.length ; i++) {
            image.drawString(text[i], 10, 20+(i*20));
        }
        
        setImage(image);
        
        for(int i=0 ; i<answers.size() ; i++) {
            getWorld().addObject(answers.get(i), 250, (text.length*30)+i*40);
        }
    }

}