package ru.mephi;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import ru.mephi.Reactor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class YAMLPars {

    ArrayList<Reactor> yamlReactors;

    public void readYAML(String directory) throws IOException {
//        yamlReactors = new ArrayList<>();
//        InputStream inputStream = new FileInputStream(new File("C:\\Users\\Елена\\IdeaProjects\\deliteLater\\src\\main\\resources\\reactor.yaml"));
//        Yaml yaml = new Yaml(new Constructor(Reactor.class));
//        yamlReactors = yaml.load(inputStream);
//        yamlReactors.addAll(data.getReactorType());


        Yaml yaml = new Yaml(new Constructor(ReactorYaml.class));
        ReactorYaml data =  yaml.load(new FileInputStream("C:\\Users\\Елена\\IdeaProjects\\deliteLater\\src\\main\\resources\\reactor.yaml"));
        yamlReactors = new ArrayList<>();
        yamlReactors.addAll(data.getReactorType());


//        String directoryy = "C:\\Users\\Елена\\IdeaProjects\\deliteLater\\src\\main\\resources\\reactor.yaml";
//        ObjectMapper objectMapper = null;
//                objectMapper = new ObjectMapper(new YAMLFactory());
//
//        Reactor[] reactorsMas = objectMapper.readValue(new File(directoryy), Reactor[].class);
//        yamlReactors = (new ArrayList<>(Arrays.asList(reactorsMas)));
    }

}
