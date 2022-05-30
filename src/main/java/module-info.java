module ru.mephi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires json.simple;
    requires org.yaml.snakeyaml;
    requires jackson.databind;
    requires jackson.dataformat.yaml;
//    requires json.simple;

    opens ru.mephi to javafx.fxml;
    exports ru.mephi;
}
