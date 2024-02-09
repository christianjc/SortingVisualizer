# Sorting Visualizer

## Description
Sorting Visualizer is a JavaFX application meticulously crafted to visually demonstrate the inner workings of various sorting algorithms. It brings algorithms to life through captivating animations, 
showcasing each step of the sorting process in an intuitive and interactive manner. This project serves a dual educational purpose: firstly, to provide a deep understanding of the mechanics behind 
common sorting algorithms such as Bubble Sort, Quick Sort, and more; secondly, to serve as a comprehensive guide for learners on how to develop a full-fledged Java application. From conceptualization 
to execution, it covers essential aspects including user interface design, application logic, and the seamless integration of UI components. This end-to-end learning experience is tailored for individuals 
aspiring to master Java application development,offering valuable insights into both algorithmic principles and practical software engineering.

## Features
- Visualize sorting algorithms in real-time.
- Control the speed of the visualization.
- Select from a variety of sorting algorithms.
- Interactive UI to control the sorting process.

## Usage
After launching the Sorting Visualizer, follow these steps to use the application:
1. Select a sorting algorithm from the dropdown menu.
2. Use the slider to adjust the visualization speed.
3. Click "Start Sort" to begin the visualization.
4. Use "Reset" to shuffle the array and prepare for another sorting visualization.
5. "Stop" can be used to halt the visualization at any time.

## Supported Sorting Algorithms
- Bubble Sort
- Quick Sort
- [Add other algorithms you've implemented]

## Contributing
We welcome contributions to the Sorting Visualizer project. If you have suggestions or improvements, please open an issue or submit a pull request.

## License
This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute the code as you see fit.

## Acknowledgments
- Thanks to [contributors name] for their contributions to this project.
- Inspired by the need for clear, visual educational tools in computer science.

## Contact
For any inquiries or further assistance, please contact [Your Name] at [your-email@example.com].

## Prerequisites
To run Sorting Visualizer, ensure you have the following installed:
- Java Development Kit (JDK) 11 or newer.
- JavaFX SDK 11 or newer, available for download from [OpenJFX](https://openjfx.io/).

## Setup

### Download JavaFX SDK
1. Download the JavaFX SDK for your operating system from the [OpenJFX Downloads](https://gluonhq.com/products/javafx/) page.
2. Extract the downloaded archive to a convenient location on your machine.

### Configure Environment Variables
- Set the `JAVA_HOME` environment variable to the path of your JDK installation.
- (Optional for convenience) Add the `bin` directory of your JDK to your system's `PATH` variable.

## Running the Application

### Windows
1. Open Command Prompt and navigate to the directory containing the `SortingVisualizer.jar` file.
2. Execute the following command, replacing `<path-to-javafx-sdk-lib>` with your actual path to the JavaFX SDK `lib` directory:

    ```cmd
    java --module-path "<path-to-javafx-sdk-lib>" --add-modules javafx.controls,javafx.fxml,javafx.graphics -jar SortingVisualizer.jar
    ```

### macOS/Linux
1. Open Terminal and navigate to the directory containing the `SortingVisualizer.jar` file.
2. Run the application using the following command, ensuring to replace `<path-to-javafx-sdk-lib>` with the correct path to the JavaFX SDK `lib` directory:

    ```sh
    java --module-path "<path-to-javafx-sdk-lib>" --add-modules javafx.controls,javafx.fxml,javafx.graphics -jar SortingVisualizer.jar
    ```

## Note
- It's important to include all necessary JavaFX modules in the `--add-modules` argument. Typically, modules like `javafx.controls`, `javafx.fxml`, and `javafx.graphics` are essential. Include additional modules if your application uses more JavaFX features, such as `javafx.media` or `javafx.web`.

Enjoy exploring various sorting algorithms with Sorting Visualizer!
