package pl.piomin.sample.spring.graphql.service;

import opennlp.tools.namefind.*;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;

import java.io.*;

public class OpenNlp {
    public static void main(String[] args) {
        try {
            // Путь к файлу с обучающими данными
            String trainingDataFile = "путь/к/файлу/train.txt";

            // Загрузка обучающих данных
            ObjectStream<NameSample> sampleStream = new NameSampleDataStream(
                    new PlainTextByLineStream((InputStreamFactory) new FileInputStream(trainingDataFile), "UTF-8"));

            // Настройка параметров обучения
            TrainingParameters params = new TrainingParameters();
            params.put(TrainingParameters.ITERATIONS_PARAM, 70);
            params.put(TrainingParameters.CUTOFF_PARAM, 1);

            // Обучение модели
            TokenNameFinderModel model = NameFinderME.train("ru", "person", sampleStream, params, TokenNameFinderFactory.create(null, null, null, new BioCodec()));

            // Сохранение модели в файл
            String modelFile = "путь/к/файлу/model.bin";
            OutputStream modelOut = new BufferedOutputStream(new FileOutputStream(modelFile));
            model.serialize(modelOut);
            System.out.println("Модель успешно обучена и сохранена в файл: " + modelFile);

            // Закрытие потока обучающих данных
            sampleStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
