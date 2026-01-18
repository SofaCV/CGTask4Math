package com.cgvsu;

import com.cgvsu.Math.Vector.Vector3;
import com.cgvsu.render_engine.RenderEngine;
import javafx.fxml.FXML;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.io.File;

import com.cgvsu.model.Model;
import com.cgvsu.objreader.ObjReader;
import com.cgvsu.render_engine.Camera;

public class GuiController {

    final private float TRANSLATION = 0.5F;

    @FXML
    AnchorPane anchorPane;

    @FXML
    private Canvas canvas;

    private Model mesh = null;

    private Camera camera = new Camera(
            new Vector3(0, 0, 100),
            new Vector3(0, 0, 0),
            1.0F, 1, 0.01F, 100);

    private Timeline timeline;

    private Vector3 scale = new Vector3(1.0f, 1.0f, 1.0f);
    private Vector3 rotation = new Vector3(0,0,0);
    private Vector3 translation = new Vector3(0,0,0);

    //кнопки для поворота
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    //кнопки для перемещения
    private boolean rotateXUp = false;
    private boolean rotateXDown  = false;
    private boolean rotateYUp  = false;
    private boolean rotateYDown  = false;

    //кнопки для масштабирования
    private boolean scaleXUp  = false;
    private boolean scaleXDown  = false;
    private boolean scaleYUp  = false;
    private boolean scaleYDown  = false;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);

        KeyFrame frame = new KeyFrame(Duration.millis(15), event -> {
            translation();
            scale();
            rotation();
            double width = canvas.getWidth();
            double height = canvas.getHeight();

            canvas.getGraphicsContext2D().clearRect(0, 0, width, height);
            camera.setAspectRatio((float) (width / height));

            if (mesh != null) {
                RenderEngine.render(
                        canvas.getGraphicsContext2D(),
                        camera,
                        mesh,
                        (int) width,
                        (int) height,
                        scale,
                        rotation,
                        translation
                );
            }
        });

        timeline.getKeyFrames().add(frame);
        timeline.play();
        setupMouseHandlers();
        setupKeyboardHandlers();
    }

    private void rotation(){
        Vector3 delta = new Vector3(0, 0, 0);
        float speed = 0.3f;

        if (rotateYUp) delta = delta.add(new Vector3(0, TRANSLATION * speed, 0));
        if (rotateYDown) delta = delta.add(new Vector3(0, -TRANSLATION * speed, 0));
        if (rotateXUp) delta = delta.add(new Vector3(-TRANSLATION * speed, 0, 0));
        if (rotateXDown) delta = delta.add(new Vector3(TRANSLATION * speed, 0, 0));

        // Накопление перемещения
        rotation = rotation.add(delta);
    }

    private void scale(){
        Vector3 delta = new Vector3(0, 0, 0);
        float speed = 0.3f;

        if (scaleYUp) delta = delta.add(new Vector3(0, TRANSLATION * speed, 0));
        if (scaleYDown) delta = delta.add(new Vector3(0, -TRANSLATION * speed, 0));
        if (scaleXUp) delta = delta.add(new Vector3(-TRANSLATION * speed, 0, 0));
        if (scaleXDown) delta = delta.add(new Vector3(TRANSLATION * speed, 0, 0));

        // Накопление перемещения
        scale = scale.add(delta);
    }

    private void translation() {
        Vector3 delta = new Vector3(0, 0, 0);
        float speed = 0.3f;

        if (upPressed) delta = delta.add(new Vector3(0, TRANSLATION * speed, 0));
        if (downPressed) delta = delta.add(new Vector3(0, -TRANSLATION * speed, 0));
        if (leftPressed) delta = delta.add(new Vector3(-TRANSLATION * speed, 0, 0));
        if (rightPressed) delta = delta.add(new Vector3(TRANSLATION * speed, 0, 0));

        // Накопление перемещения
        translation = translation.add(delta);
    }


    private void setupKeyboardHandlers() {
        canvas.setFocusTraversable(true);

        // Обработка нажатия стрелок
        canvas.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP -> upPressed = true;
                case DOWN -> downPressed = true;
                case LEFT -> leftPressed = true;
                case RIGHT -> rightPressed = true;

                case DIGIT1 -> rotateYUp = true;
                case DIGIT2 -> rotateYDown = true;
                case DIGIT3 -> rotateXUp = true;
                case DIGIT4 -> rotateXDown = true;

                case DIGIT5 -> scaleYUp = true;
                case DIGIT6 -> scaleYDown = true;
                case DIGIT7 -> scaleXUp = true;
                case DIGIT8 -> scaleXDown = true;
            }
        });

        // Обработка отпускания стрелок
        canvas.setOnKeyReleased(event -> {
            switch (event.getCode()) {

                case UP -> upPressed = false;
                case DOWN -> downPressed = false;
                case LEFT -> leftPressed = false;
                case RIGHT -> rightPressed = false;

                case DIGIT1 -> rotateYUp = false;
                case DIGIT2 -> rotateYDown = false;
                case DIGIT3 -> rotateXUp = false;
                case DIGIT4 -> rotateXDown = false;

                case DIGIT5 -> scaleYUp = false;
                case DIGIT6 -> scaleYDown = false;
                case DIGIT7 -> scaleXUp = false;
                case DIGIT8 -> scaleXDown = false;

                case R -> resetTransformations();}
        });
    }
    private void resetTransformations(){
        scale = new Vector3(1.0f, 1.0f, 1.0f);
        rotation = new Vector3(0,0,0);
        translation = new Vector3(0,0,0);

    }
    private void setupMouseHandlers() {
        // зум
        canvas.setOnScroll(event -> {
            float speed = 0.1f;
            double deltaY = event.getDeltaY();
            float zoomDelta = (float) (deltaY * speed);
            Vector3 direction = camera.getZ().normalization();
            Vector3 newPosition = camera.getPosition().add(direction.multiByScalar(zoomDelta));
            if ((newPosition.subtract(camera.getTarget())).vectorLength() > 0.5f) {
                camera.setPosition(newPosition);
            }
        });
    }

    @FXML
    private void onOpenModelMenuItemClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Model (*.obj)", "*.obj"));
        fileChooser.setTitle("Load Model");

        File file = fileChooser.showOpenDialog((Stage) canvas.getScene().getWindow());
        if (file == null) {
            return;
        }

        Path fileName = Path.of(file.getAbsolutePath());

        try {
            String fileContent = Files.readString(fileName);
            mesh = ObjReader.read(fileContent);
            // todo: обработка ошибок
        } catch (IOException exception) {

        }
    }

    @FXML
    public void handleCameraForward(ActionEvent actionEvent) {
        camera.movePosition(new Vector3(0, 0, -TRANSLATION));
    }

    @FXML
    public void handleCameraBackward(ActionEvent actionEvent) {
        camera.movePosition(new Vector3(0, 0, TRANSLATION));
    }

    @FXML
    public void handleCameraLeft(ActionEvent actionEvent) {
        camera.movePosition(new Vector3(TRANSLATION, 0, 0));
    }

    @FXML
    public void handleCameraRight(ActionEvent actionEvent) {
        camera.movePosition(new Vector3(-TRANSLATION, 0, 0));
    }

    @FXML
    public void handleCameraUp(ActionEvent actionEvent) {
        camera.movePosition(new Vector3(0, TRANSLATION, 0));
    }

    @FXML
    public void handleCameraDown(ActionEvent actionEvent) {
        camera.movePosition(new Vector3(0, -TRANSLATION, 0));
    }
}