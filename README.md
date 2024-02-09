# Sorting Visualizer

## Description
Sorting Visualizer is a JavaFX application meticulously crafted to visually demonstrate the inner workings of various sorting algorithms. It brings algorithms to life through captivating animations, showcasing each step of the sorting process in an intuitive and interactive manner. This project serves a dual educational purpose: firstly, to provide a deep understanding of the mechanics behind common sorting algorithms such as Bubble Sort, Quick Sort, and more; secondly, to serve as a comprehensive guide for learners on how to develop a full-fledged Java application. From conceptualization to execution, it covers essential aspects including user interface design, application logic, and the seamless integration of UI components. This end-to-end learning experience is tailored for individuals aspiring to master Java application development, offering valuable insights into both algorithmic principles and practical software engineering.

## Table of Contents

- [Features](#features)
- 
- [Quick Start](#quick-start)
- [Prerequisites](#prerequisites)
- [Dependencies](#dependencies)
- [Testing Dependencies](#testing-dependencies)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [Usage](#usage)
- [Supported Sorting Algorithms](#supported-sorting-algorithms)
- 
- [Learning Opportunities](#learning-opportunities)
- [Contributing](#contributing)
- [Roadmap](#roadmap)
- [Acknowledgments](#acknowledgments)
- [Contact](#contact)
- [License](#license)
- [Note](#note)


- [Features](#features)
- [For Users](#for-users)
  - [Quick Start](#quick-start)
  - [Usage](#usage)
  - [Supported Sorting Algorithms](#supported-sorting-algorithms)
- [For Developers](#for-developers)
  - [Prerequisites](#prerequisites)
  - [Dependencies](#dependencies)
  - [Testing Dependencies](#testing-dependencies)
  - [Setup](#setup)
  - [Compiling and Running from Source](#compiling-and-running-from-source)
- [Learning Opportunities](#learning-opportunities)
- [Contributing](#contributing)
- [Roadmap](#roadmap)
- [Acknowledgments](#acknowledgments)
- [Contact](#contact)
- [License](#license)
- [Note](#note)


## Features
- Visualize sorting algorithms in real-time.
- Control the speed of the visualization.
- Select from a variety of sorting algorithms.
- Interactive UI to control the sorting process.

## Prerequisites
This prerequesites are for both users and developers. Before you begin, ensure you have the following software installed on your system:
-   **Java Development Kit (JDK) 11 or newer**: Required to compile and run Java applications. [Download JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
-   **JavaFX SDK 11 or newer**: Required for JavaFX applications. [Download JavaFX SDK](https://gluonhq.com/products/javafx/)

## For Users

### Quick Start

These instructions will guide you through getting the souce code, compiling and running the Sorting Visualizer app.


#### Setup

1. **Clone or Download the Source Code**: Obtain the source code by cloning this repository or downloading it as a ZIP file and extracting it to your desired location.

2. **Set Up JavaFX**: Ensure the JavaFX SDK is extracted and note the path to its `lib` directory, as it will be required to compile and run the application.






#### Compiling and Running the Application

#### Windows
1. **Open Command Prompt**: Navigate to the root directory of the Sorting Visualizer project where the source code is located.
2. **Compile the Source Code**: Run the following command to compile all Java files, replacing `C:\javafx-sdk-11\lib\*` with the actual path to your JavaFX SDK `lib` directory:

   ```cmd
   javac -d out -cp "C:\javafx-sdk-11\lib\*" src\main\java\com\sortingvisualizer\util\SortingAlgorithmType.java          src\main\java\com\sortingvisualizer\controller\SortingVisualizerController.java src\main\java\com\sortingvisualizer\MainApp.java src\main\java\com\sortingvisualizer\model\QuickSort.java src\main\java\com\sortingvisualizer\model\SortingAlgorithm.java src\main\java\com\sortingvisualizer\model\BubbleSort.java src\main\java\com\sortingvisualizer\view\VisualizerCanvas.java
    ```
   This command compiles all Java files in the project and places the generated `.class` files in the `out` directory.
   
3.**Run the Application***: After compiling the source code, you can run the application using the following command, again replacing `/path/to/javafx-sdk/lib` with the actual path to your JavaFX SDK `lib` directory:
    ```cmd
    java --module-path "C:\javafx-sdk-11\lib" --add-modules javafx.controls,javafx.fxml,javafx.graphics -cp out com.sortingvisualizer.MainApp
    ```

#### macOS/Linux

1. **Open Terminal**: Navigate to the root directory of the Sorting Visualizer project where the source code is located.

2. **Compile the Source Code**: Run the following command to compile all Java files, replacing `/path/to/javafx-sdk/lib` with the actual path to your JavaFX SDK `lib` directory:

    ```sh
    javac -d out -cp "/path/to/javafx-sdk/lib/*" src/main/java/com/sortingvisualizer/**/*.java
    ```

    This command compiles all Java files in the project and places the generated `.class` files in the `out` directory.
   

    ```







### Running the Application

After compiling the source code, you can run the application using the following command, again replacing `/path/to/javafx-sdk/lib` with the actual path to your JavaFX SDK `lib` directory:

    ```sh
    java --module-path "/path/to/javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml,javafx.graphics -cp "out:src/main/resources" com.sortingvisualizer.MainApp
    ```

This command sets the module path to include JavaFX modules and specifies the classpath to include both the compiled `.class` files and the resources directory.

### Quick Start
To run the Sorting Visualizer application without setting up a development environment, you will need a pre-compiled `SortingVisualizer.jar` file. Follow the instructions below to run the application:

#### Windows
1. Open Command Prompt and navigate to the directory containing the `SortingVisualizer.jar` file.
2. Execute the following command, replacing `<path-to-javafx-sdk-lib>` with your actual path to the JavaFX SDK `lib` directory:
    ```cmd
    java --module-path "<path-to-javafx-sdk-lib>" --add-modules javafx.controls,javafx.fxml,javafx.graphics -jar SortingVisualizer.jar
    ```

#### macOS/Linux
1. Open Terminal and navigate to the directory containing the `SortingVisualizer.jar` file.
2. Run the application using the following command, ensuring to replace `<path-to-javafx-sdk-lib>` with the correct path to the JavaFX SDK `lib` directory:
    ```sh
    java --module-path "<path-to-javafx-sdk-lib>" --add-modules javafx.controls,javafx.fxml,javafx.graphics -jar SortingVisualizer.jar
    ```

### Usage
After launching the Sorting Visualizer, you can:
1. Select a sorting algorithm from the dropdown menu.
2. Use the slider to adjust the visualization speed.
3. Click "Start Sort" to begin the visualization.
4. Use "Reset" to shuffle the array and prepare for another sorting visualization.
5. "Stop" can be used to halt the visualization at any time.

### Supported Sorting Algorithms
- Bubble Sort
- Quick Sort
- More in progress...

## Quick Start With IntelliJ IDE
1. Ensure Java JDK 11+ and JavaFX SDK 11+ are installed.
2. Download or clone the Sorting Visualizer repository.
3. Configure JavaFX in your IDE or set up environment variables as described in the Setup section.
4. Run the application using your IDE or the command line instructions provided below.

## Prerequisites
To run Sorting Visualizer, ensure you have the following installed:
- Java Development Kit (JDK) 11 or newer.
- JavaFX SDK 11 or newer, available for download from [OpenJFX](https://openjfx.io/).

## Dependencies

This project relies on the following dependencies:

- **[JavaFX SDK 11](https://openjfx.io/) or newer**: Utilized for UI components and animations. Ensure you have the JavaFX SDK properly set up and configured with your IDE or build tool.
- **[JUnit 5](https://junit.org/junit5/)**: Employed for unit testing. Ensure JUnit 5 is included in your project's build path if you're implementing unit tests.

## Testing Dependencies

For unit testing and mocking within the Sorting Visualizer project, the following specific libraries and their versions are employed:

- **[Mockito-Core 5.10.0](https://search.maven.org/artifact/org.mockito/mockito-core/5.10.0/jar)**: Used for mocking objects in tests, enabling isolated testing of components. Mockito simplifies the creation of mock objects and verification of interactions.

- **[Byte Buddy 1.14.11](https://search.maven.org/artifact/net.bytebuddy/byte-buddy/1.14.11/jar)** and **[Byte Buddy Agent 1.14.11](https://search.maven.org/artifact/net.bytebuddy/byte-buddy-agent/1.14.11/jar)**: Byte Buddy is a code generation and manipulation library for Java, used by Mockito for dynamically creating mock objects at runtime. The Byte Buddy Agent is used to redefine classes at runtime, which is essential for certain types of mocks and stubs.

- **[Objenesis 3.3](https://search.maven.org/artifact/org.objenesis/objenesis/3.3/jar)**: A library for instantiating Java objects without invoking their constructors, used by Mockito to create instances of mock objects.

Ensure these libraries are correctly configured in your project's build path or dependency management system to facilitate effective testing.

## Setup
### Download JavaFX SDK
1. Download the JavaFX SDK for your operating system from the [OpenJFX Downloads](https://gluonhq.com/products/javafx/) page.
2. Extract the downloaded archive to a convenient location on your machine.

### Configure Environment Variables
- Set the `JAVA_HOME` environment variable to the path of your JDK installation.

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
- More in progress...

## Learning Opportunities
Engaging with the Sorting Visualizer project offers a comprehensive learning experience, covering a wide range of programming and software engineering concepts:

- **JavaFX Framework**: Dive into the essentials of JavaFX to create engaging and interactive user interfaces.
  
- **MVC Architecture**: Learn the Model-View-Controller (MVC) design pattern to structure your code for better maintainability and readability.
  
- **Sorting Algorithms**: Explore the mechanics behind various sorting algorithms, understanding their logic, implementation, and performance characteristics.
  
- **Animation and Timing**: Utilize animations to bring data operations to life, making the sorting process visually intuitive.
  
- **Event Handling**: Master the art of handling user interactions to make your applications responsive and user-friendly.
  
- **Simple Multithreading**: Discover the basics of multithreading in Java to improve application performance and responsiveness, especially in UI-driven apps.
  
- **Object-Oriented Programming (OOP) Principles**: Deepen your understanding of OOP by implementing, extending, overriding, and overloading classes and methods, fostering reusable and adaptable code.
  
- **Modular Programming**: Get acquainted with modular programming practices in Java, which promote code reusability and enhance project maintainability.
  
- **Testing with JUnit and Mockito**: Develop proficiency in automated testing by writing unit tests with JUnit and leveraging Mockito for mocking dependencies. Learn the pivotal role of testing in ensuring code reliability and maintainability.
  
- **Project Structure**: Gain practical insights into effectively structuring a Java project, managing dependencies, and the nuances of building a project from the ground up.

This project serves as an ideal springboard for beginners and those looking to solidify their grasp of Java application development, offering a hands-on approach to learning software development principles and best practices.

## Contributing
Sorting Visualizer is an evolving project, and we encourage contributions from the community. Whether you're fixing bugs, adding new features, or improving documentation, your help is welcome. Please refer to the [CONTRIBUTING.md](CONTRIBUTING.md) for detailed instructions on how to contribute.

## Roadmap
Future updates will focus on adding more sorting algorithms, enhancing UI interactivity, optimizing performance, and expanding educational content. We are also exploring features like algorithm comparison modes and user-defined datasets.

## Acknowledgments
This project is inspired by the need for clear, visual educational tools in computer science. Special thanks to the JavaFX community for providing extensive resources and support.

## Contact
For inquiries or support, please reach out to us at christianjc.engineer@gmail.com

## License
This project is licensed under the [MIT License](LICENSE.md). Feel free to use, modify, and distribute the code as you see fit.

## Note


Enjoy exploring various sorting algorithms with Sorting Visualizer!

