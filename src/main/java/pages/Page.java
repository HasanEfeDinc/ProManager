package pages;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// ABSTRACT PAGE CLASS FOR BASE OF IMPLEMENTED ALL THE PAGE CLASSES TO HANDLES SOME FEATURES
public abstract class Page {

    protected final int w= 850;
    protected final int h = 650;
    protected   Scene scene ;
    protected Stage stage ;
    protected StackPane pane;

    protected final boolean resizable = false;


    protected void createPage(Stage stage){
        this.stage = stage;
        stage.setResizable(resizable);
        setHandlers();
    };

    public Stage getStage() {
        return stage;
    }

    public void show(){ stage.show();}

    protected void setHandlers(){}
}

