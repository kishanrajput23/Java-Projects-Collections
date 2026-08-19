
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class HandwrittendigitRecognition{

    // Class representing a single sample (pixel values + label)
    static class Sample {
        double[] pixels;  // Array of pixel values
        int label;        // Label (digit)
        
        // Constructor
        Sample(double[] pixels, int label) {
            this.pixels = pixels;
            this.label = label;
        }
    }

    // Method to load the dataset (CSV format) into a list of Samples
    public static List<Sample> loadDataset(String filename) throws IOException {
        List<Sample> dataset = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            int label = Integer.parseInt(values[0]);  // The first value is the label
            double[] pixels = new double[784];  // 28x28 flattened image = 784 pixels
            for (int i = 0; i < 784; i++) {
                pixels[i] = Integer.parseInt(values[i + 1]) / 255.0;  // Normalize pixel values
            }
            dataset.add(new Sample(pixels, label));
        }
        br.close();
        return dataset;
    }

    // Method to calculate Euclidean distance between two samples
    public static double euclideanDistance(double[] a, double[] b) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.pow(a[i] - b[i], 2);
        }
        return Math.sqrt(sum);
    }

    // k-NN algorithm: Classify the test sample based on the k nearest neighbors
    public static int knn(List<Sample> trainSet, double[] testSample, int k) {
        // List of distances (distance, label)
        List<Map.Entry<Double, Integer>> distances = new ArrayList<>();
        
        // Calculate the distance between the test sample and each training sample
        for (Sample trainSample : trainSet) {
            double dist = euclideanDistance(testSample, trainSample.pixels);
            distances.add(new AbstractMap.SimpleEntry<>(dist, trainSample.label));
        }
        
        // Sort by distance (ascending order)
        distances.sort(Comparator.comparing(Map.Entry::getKey));

        // Perform majority voting (take the label with the most occurrences)
        int[] votes = new int[10];  // There are 10 possible labels (0-9)
        for (int i = 0; i < k; i++) {
            int label = distances.get(i).getValue();
            votes[label]++;
        }

        // Find the label with the maximum votes
        int predictedLabel = 0;
        for (int i = 1; i < votes.length; i++) {
            if (votes[i] > votes[predictedLabel]) {
                predictedLabel = i;
            }
        }

        return predictedLabel;
    }

    // Method to calculate accuracy on the test set
    public static double calculateAccuracy(List<Sample> testSet, List<Sample> trainSet, int k) {
        int correct = 0;
        for (Sample testSample : testSet) {
            int predictedLabel = knn(trainSet, testSample.pixels, k);
            if (predictedLabel == testSample.label) {
                correct++;
            }
        }
        return (double) correct / testSet.size() * 100;  // Return accuracy as percentage
    }

    public static void main(String[] args) {
        try {
            // Load dataset (e.g., train.csv and test.csv files)
            List<Sample> trainSet = loadDataset("train.csv");
            List<Sample> testSet = loadDataset("test.csv");

            // Set k (number of nearest neighbors)
            int k = 3;

            // Calculate accuracy
            double accuracy = calculateAccuracy(testSet, trainSet, k);
            System.out.println("Accuracy: " + accuracy + "%");

            // Example: Predict a single test sample (you can select any index)
            Sample testSample = testSet.get(0);
            int predictedLabel = knn(trainSet, testSample.pixels, k);
            System.out.println("Predicted label for the first test sample: " + predictedLabel);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
