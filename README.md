# Sorting Visualizer

## Description
Sorting Visualizer is a JavaFX application meticulously crafted to visually demonstrate the inner workings of various sorting algorithms. It brings algorithms to life through captivating animations, showcasing each step of the sorting process in an intuitive and interactive manner. This project serves a dual educational purpose: firstly, to provide a deep understanding of the mechanics behind common sorting algorithms such as Bubble Sort, Quick Sort, and more; secondly, to serve as a comprehensive guide for learners on how to develop a full-fledged Java application. From conceptualization to execution, it covers essential aspects including user interface design, application logic, and the seamless integration of UI components. This end-to-end learning experience is tailored for individuals aspiring to master Java application development, offering valuable insights into both algorithmic principles and practical software engineering.

## Table of Contents

- [Key Features](#key-features)
- [Prerequisites](#prerequisites)
- [For Users](#for-users)
  - [Quick Start Guide](#quick-start-guide)
  - [Usage](#usage)
  - [Supported Sorting Algorithms](#supported-sorting-algorithms)
- [For Developers](#for-developers)
  - [Dev Quick Start](#dev-quick-start)
  - [Dependencies](#dependencies)
  - [Testing Dependencies](#testing-dependencies)
- [Learning Opportunities](#learning-opportunities)
- [Contributing](#contributing)
- [Roadmap](#roadmap)
- [Acknowledgments](#acknowledgments)
- [Contact](#contact)
- [License](#license)
- [Note](#note)


## Key Features

The Sorting Visualizer is designed with user engagement and educational value in mind, offering:

- **Real-Time Visualization**: Experience the dynamic process of sorting algorithms through real-time animations, providing a clear understanding of their operational flow.
- **Speed Control**: Gain control over the visualization pace, allowing for a customized viewing experience that caters to individual learning speeds.
- **Algorithm Selection**: Choose from a diverse range of sorting algorithms to visualize, offering insights into their comparative efficiencies and methodologies.
- **Interactive Interface**: Engage with an intuitive UI that facilitates easy control over the visualization process, enhancing the learning and user experience.

## Prerequisites

To ensure a smooth experience with the Sorting Visualizer, both users and developers are required to have the following installations on their systems:

- **Java Development Kit (JDK) 11 or Newer**: A fundamental requirement for compiling and running Java-based applications. Secure the latest version from the [official JDK download page](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **JavaFX SDK 11 or Newer**: Essential for running JavaFX applications, providing the graphical user interface for the Sorting Visualizer. Obtain it from the [OpenJFX Downloads](https://gluonhq.com/products/javafx/) portal.


## For Users

### Quick Start Guide

Follow this streamlined process to obtain the source code, compile, and launch the Sorting Visualizer application:


#### Setup Instructions

Quickly prepare your environment for running the Sorting Visualizer:

1. **Get the Source Code**: Clone this GitHub repository or download it as a ZIP and extract it to a directory of your choice.

    ```bash
    git clone https://github.com/christianjc/SortingVisualizer.git
    ```

2. **Acquire JavaFX SDK**: Visit the [OpenJFX Downloads](https://gluonhq.com/products/javafx/) page and download the SDK compatible with your operating system.

3. **Configure JavaFX**: Unzip the JavaFX SDK to a preferred location. Remember the path to its `lib` folder, as it will be essential for compilation and execution of the application.


#### Compiling and Running the Application

##### Windows
1. **Open Command Prompt**: Navigate to the root directory of the Sorting Visualizer project where the source code is located.
2. **Compile the Source Code**: Run the following command to compile all Java files, replacing `C:\javafx-sdk-11\lib\*` with the actual path to your JavaFX SDK `lib` directory:

   ```cmd
   javac -d out -cp "C:\javafx-sdk-11\lib\*" src\main\java\com\sortingvisualizer\util\SortingAlgorithmType.java    src\main\java\com\sortingvisualizer\controller\SortingVisualizerController.java src\main\java\com\sortingvisualizer\MainApp.java src\main\java\com\sortingvisualizer\model\QuickSort.java src\main\java\com\sortingvisualizer\model\SortingAlgorithm.java src\main\java\com\sortingvisualizer\model\BubbleSort.java src\main\java\com\sortingvisualizer\view\VisualizerCanvas.java
   ```
   
    This command compiles all Java files in the project and places the generated `.class` files in the `out` directory.
   
3. **Run the Application***: After compiling the source code, you can run the application using the following command, again replacing `C:\javafx-sdk-11\lib` with the actual path to your JavaFX SDK `lib` directory:

    ```cmd
    java --module-path "C:\path\to\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml,javafx.graphics -cp "out;src\main\resources" com.sortingvisualizer.MainApp
    ```


##### macOS/Linux
1. **Open Terminal**: Navigate to the root directory of the Sorting Visualizer project where the source code is located.
2. **Compile the Source Code**: Run the following command to compile all Java files, replacing `/path/to/javafx-sdk/lib` with the actual path to your JavaFX SDK `lib` directory:

    ```sh
    javac -d out -cp "/path/to/javafx-sdk/lib/*" src/main/java/com/sortingvisualizer/**/*.java
    ```

    This command compiles all Java files in the project and places the generated `.class` files in the `out` directory.

3. **Run the Application**: After compiling the source code, you can run the application using the following command, again replacing `/path/to/javafx-sdk/lib` with the actual path to your JavaFX SDK `lib` directory:

   ```sh
    java --module-path "/path/to/javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml,javafx.graphics -cp "out:src/main/resources" com.sortingvisualizer.MainApp
   ```

   This command sets the module path to include JavaFX modules and specifies the classpath to include both the compiled `.class` files and the resources directory.



### Usage
Once the Sorting Visualizer is up and running, you have several interactive options at your disposal:

1. **Select an Algorithm**: Choose your desired sorting algorithm from the dropdown menu to understand its sorting mechanism visually.
   
2. **Adjust Speed**: Use the slider control to fine-tune the speed of the sorting visualization, allowing for a more detailed observation or a quicker overview, as per your preference.

3. **Initiate Sorting**: Press the "Start Sort" button to kick off the visualization of the chosen sorting algorithm. Watch as the algorithm methodically sorts the data, providing a clear illustration of its process.

4. **Shuffle and Restart**: Click the "Reset" button to shuffle the dataset, setting the stage for a new round of visualization. This is particularly useful for comparing the efficiency of different algorithms on various data arrangements.

5. **Pause the Visualization**: Use the "Stop" button to pause the ongoing visualization. This can be helpful if you wish to take a closer look at a specific moment in the sorting process.

   **Note**: If you press "Start Sort" after stopping the visualization, the sorting will resume using the current dataset state. This feature is designed to highlight how certain algorithms might behave differently depending on the degree of sorting already present in the dataset. It offers a unique insight into the adaptive nature of some sorting algorithms when faced with partially sorted data.


### Supported Sorting Algorithms
- Bubble Sort
- Quick Sort
- More in progress...


## For Developers

### Developer Quick Start Guide

Jumpstart your development with the Sorting Visualizer by following these simple steps:

1. **Install JDK and JavaFX**: Verify that Java Development Kit (JDK) version 11 or newer is installed on your system. Additionally, download and install JavaFX SDK version 11 or higher. These are crucial for compiling and running JavaFX applications.

    - [Download JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
    - [Download JavaFX SDK](https://gluonhq.com/products/javafx/)

2. **Obtain the Source Code**: Clone the Sorting Visualizer repository to your local machine or download it as a ZIP archive and extract it to your preferred directory.

    ```sh
    git clone https://github.com/christianjc/SortingVisualizer.git
    ```


3. **Configure the JDK Environment**: Set the `JAVA_HOME` environment variable to point to your JDK installation directory. This step ensures that your development tools can locate the JDK binaries.

    - **Windows**: [Setting JAVA_HOME on Windows](https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html)
    - **macOS/Linux**: Add `export JAVA_HOME=/path/to/jdk` to your shell profile (`~/.bash_profile`, `~/.zshrc`, etc.)

4. **Set Up JavaFX in Your IDE**: Integrate JavaFX into your Integrated Development Environment (IDE) to leverage its powerful features for UI development. This typically involves adding the JavaFX SDK as a library in your project settings and configuring the module-path to include JavaFX modules.

    - For detailed instructions, refer to your IDE's documentation or the [JavaFX and IDEs](https://openjfx.io/openjfx-docs/#IDE) section of the OpenJFX documentation.

5. **Launch the Application**: Use your IDE's run functionality to start the Sorting Visualizer application. Ensure that the IDE is configured to use the JDK installation specified in your `JAVA_HOME` and that JavaFX libraries are correctly referenced.

By following these steps, you'll have a local development environment set up for the Sorting Visualizer, allowing you to explore, modify, and enhance the application.


### Dependencies
This project relies on the following dependencies:

- **[JavaFX SDK 11](https://openjfx.io/) or newer**: Utilized for UI components and animations. Ensure you have the JavaFX SDK properly set up and configured with your IDE or build tool.
- **[JUnit 5](https://junit.org/junit5/)**: Employed for unit testing. Ensure JUnit 5 is included in your project's build path if you're implementing unit tests.


### Testing Dependencies
For unit testing and mocking within the Sorting Visualizer project, the following specific libraries and their versions are employed:

- **[Mockito-Core 5.10.0](https://search.maven.org/artifact/org.mockito/mockito-core/5.10.0/jar)**: Used for mocking objects in tests, enabling isolated testing of components. Mockito simplifies the creation of mock objects and verification of interactions.

- **[Byte Buddy 1.14.11](https://search.maven.org/artifact/net.bytebuddy/byte-buddy/1.14.11/jar)** and **[Byte Buddy Agent 1.14.11](https://search.maven.org/artifact/net.bytebuddy/byte-buddy-agent/1.14.11/jar)**: Byte Buddy is a code generation and manipulation library for Java, used by Mockito for dynamically creating mock objects at runtime. The Byte Buddy Agent is used to redefine classes at runtime, which is essential for certain types of mocks and stubs.

- **[Objenesis 3.3](https://search.maven.org/artifact/org.objenesis/objenesis/3.3/jar)**: A library for instantiating Java objects without invoking their constructors, used by Mockito to create instances of mock objects.

Ensure these libraries are correctly configured in your project's build path or dependency management system to facilitate effective testing.


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

