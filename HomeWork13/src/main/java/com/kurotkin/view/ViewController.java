package com.kurotkin.view;

import com.kurotkin.youtube.entities.Snippet;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by Андрей on 29.09.2017.
 */
public class ViewController {
    @FXML
    private TableView<Snippet> personTable;
    @FXML
    private TableColumn<Snippet, String> publishedAtColumn;
    @FXML
    private TableColumn<Snippet, String> descriptionColumn;
    @FXML
    private TableColumn<Snippet, String> titleColumn;

    @FXML
    private void initialize() {
        // Заполнение таблицы
        titleColumn.cellFactoryProperty(cell -> cell.getValue().)

    }
}
