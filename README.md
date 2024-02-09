# Sorting Visualizer

## Description
Sorting Visualizer is a JavaFX application meticulously crafted to visually demonstrate the inner workings of various sorting algorithms. It brings algorithms to life through captivating animations, showcasing each step of the sorting process in an intuitive and interactive manner. This project serves a dual educational purpose: firstly, to provide a deep understanding of the mechanics behind common sorting algorithms such as Bubble Sort, Quick Sort, and more; secondly, to serve as a comprehensive guide for learners on how to develop a full-fledged Java application. From conceptualization to execution, it covers essential aspects including user interface design, application logic, and the seamless integration of UI components. This end-to-end learning experience is tailored for individuals aspiring to master Java application development, offering valuable insights into both algorithmic principles and practical software engineering.

## Table of Contents

- [Quick Start](#quick-start)
- [Features](#features)
- [Usage](#usage)
- [Supported Sorting Algorithms](#supported-sorting-algorithms)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [Learning Opportunities](#learning-opportunities)
- [Contributing](#contributing)
- [Engage with Us!](#engage-with-us)
- [Dependencies](#dependencies)
- [Acknowledgments](#acknowledgments)
- [License](#license)
- [Contact](#contact)


## Features
- Visualize sorting algorithms in real-time.
- Control the speed of the visualization.
- Select from a variety of sorting algorithms.
- Interactive UI to control the sorting process.

## Quick Start
1. Ensure Java JDK 11+ and JavaFX SDK 11+ are installed.
2. Download or clone the Sorting Visualizer repository.
3. Configure JavaFX in your IDE or set up environment variables as described in the Setup section.
4. Run the application using your IDE or the command line instructions provided below.

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
For inquiries or support, please reach out to us at sortingvisualizer@example.com.

## License
This project is licensed under the [MIT License](LICENSE.md). Feel free to use, modify, and distribute the code as you see fit.

## Note
- It's important to include all necessary JavaFX modules in the `--add-modules` argument. Typically, modules like `javafx.controls`, `javafx.fxml`, and `javafx.graphics` are essential. Include additional modules if your application uses more JavaFX features, such as `javafx.media` or `javafx.web`.

Enjoy exploring various sorting algorithms with Sorting Visualizer!

