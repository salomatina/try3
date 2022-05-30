package ru.mephi;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



import java.io.File;
import java.util.ArrayList;

public class App extends Application {

    private TreeView<String> reactorsTreeView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextArea textAreaJson = new TextArea();
        textAreaJson.setEditable(false);
        Group groupTextAreaJson = new Group(textAreaJson);
        textAreaJson.setPrefSize(300, 20);
        Button buttonJsonCh = new Button("...");
        buttonJsonCh.setPrefSize(30, 37);
        buttonJsonCh.setOnAction(actionEvent -> {
            textAreaJson.clear();
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                textAreaJson.appendText(file.getAbsolutePath());
            }
        });
        Group groupButtonImpDir = new Group(buttonJsonCh);
        Button buttonImp = new Button("Import");
        buttonImp.setPrefSize(80, 37);
        buttonImp.setOnAction(event -> {
            System.out.println(textAreaJson.getText().toString());
            try {
//                YAMLPars yamlPars = new YAMLPars();
//                yamlPars.readYAML("C:\\Users\\Елена\\IdeaProjects\\deliteLater\\src\\main\\resources\\reactor.yaml");
//                setReactorsTreeView(yamlPars.yamlReactors);
                if (textAreaJson.getText() != null && textAreaJson.getText().contains(".yaml")) {
                    YAMLPars yamlPars = new YAMLPars();
                    yamlPars.readYAML(textAreaJson.getText());
                    setReactorsTreeView(yamlPars.yamlReactors);
                }
                else if (textAreaJson.getText() != null && textAreaJson.getText().contains(".xml")){
                    XMLPars xmlPars = new XMLPars();
                    xmlPars.read(textAreaJson.getText());
                    setReactorsTreeView(xmlPars.xmlReactors);

                }
                else if (textAreaJson.getText() != null && textAreaJson.getText().contains(".json")) {
                    JSONPars jsonPars = new JSONPars();
                    jsonPars.getJSONArray(textAreaJson.getText());
                    setReactorsTreeView(jsonPars.jsonReactors);
                }
                else {
                    throw new NullPointerException("Directory isn't chosen");
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Good job!");
                alert.setHeaderText(null);
                alert.setContentText("Done");
                alert.showAndWait();
            } catch (Exception exception) {
//                System.out.println(exception.toString());
                exception.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Warning!!!");
                alert.setHeaderText(null);
                alert.setContentText("Something went wrong and we didn't find a file");
                alert.showAndWait();
            }
        });
        Group groupButtonImp = new Group(buttonImp);
//        Group tree = new Group(reactorsTreeView);
//        reactorsTreeView.setPrefSize(170, 200);
//        HBox tree = new HBox();
//        VBox tree1 = new VBox();
//        tree.getChildren().addAll(reactorsTreeView);
        //Group treeGroup = new Group(tree);
        reactorsTreeView = new TreeView<>();
        reactorsTreeView.setPrefSize(410, 360);
        HBox tree = new HBox();
        tree.getChildren().addAll(reactorsTreeView);
        tree.setPrefSize(510, 350);


        HBox importChild = new HBox(groupButtonImpDir, groupTextAreaJson, groupButtonImp);
        VBox root = new VBox(importChild, tree);
        Scene scene = new Scene(root, 410, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("let's do something!");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public void setReactorsTreeView(ArrayList<Reactor> reactors) {
        TreeItem<String> rootItem = new TreeItem<>("Reactors");
        for (Reactor reactor : reactors) {
            TreeItem<String> branchItem = new TreeItem<>(reactor.type);
            TreeItem<String> leafItem1 = new TreeItem<>("name : " + reactor.type);
            TreeItem<String> leafItem2 = new TreeItem<>("burnup : " + reactor.burnup);
            TreeItem<String> leafItem3 = new TreeItem<>("kpd : " + reactor.kpd);
            TreeItem<String> leafItem4 = new TreeItem<>("enrichment : " + reactor.enrichment);
            TreeItem<String> leafItem5 = new TreeItem<>("termalCapacity : " + reactor.termalCapacity);
            TreeItem<String> leafItem6 = new TreeItem<>("electricalCapacity : " + reactor.electricalCapacity);
            TreeItem<String> leafItem7 = new TreeItem<>("lifeTime : " + reactor.lifeTime);
            TreeItem<String> leafItem8 = new TreeItem<>("firstLoad : " + reactor.firstLoad);
            TreeItem<String> leafItem9 = new TreeItem<>("source : " + reactor.source);

            branchItem.getChildren().addAll(leafItem1, leafItem2, leafItem3, leafItem4, leafItem5, leafItem6, leafItem7, leafItem8, leafItem9);
            rootItem.getChildren().add(branchItem);
        }

        reactorsTreeView.setRoot(rootItem);
        reactorsTreeView.setShowRoot(false);
    }
}
