# Entrata Automation Tests

This project contains automated tests for the Entrata website using Selenium WebDriver and TestNG.

## Description

The project includes various test cases to verify the functionality of the Entrata website, such as checking the homepage title, accepting cookie consent, navigating to different pages, and verifying the presence of the login button.

## Installation

1. **Clone the repository**:
    ```sh
    git clone https://github.com/BhagyashreeSSathe/entrata-automation.git
    cd entrata-automation
    ```

2. **Install dependencies**:
    Ensure you have Maven installed. Then, run:
    ```sh
    mvn clean install
    ```

3. **Set up WebDriver**:
    Download the appropriate WebDriver for your browser and set the path in your system environment variables.

## Usage

1. **Run the tests**:
    You can run the tests using Maven:
    ```sh
    mvn test
    ```

2. **View test results**:
    Test results will be available in the `target/surefire-reports` directory.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.