
# Tasker CLI

Tasker CLI is a simple command-line tool for managing tasks. It allows you to add, update, delete, mark tasks as in-progress or done, and list tasks directly from your terminal.

## Features

- Add new tasks
- Update existing tasks
- Delete tasks
- Mark tasks as in-progress
- Mark tasks as done
- List all tasks

## Prerequisites

- Java 21
- Gradle 8.8
- Spring Boot 3.3.2

## Getting Started

### Clone the Repository

```sh
git clone https://github.com/luciusfox9/Tasker.git
cd Tasker
```

### Build the Project

```sh
./gradlew clean build
```

### Create the CLI Script

Create a shell script to run the JAR file:

```sh
echo '#!/bin/bash\n\n# Path to your JAR file\nJAR_PATH="/path/to/project/Tasker/build/libs/Tasker-0.0.1-SNAPSHOT.jar"\n\n# Run the JAR file with the provided arguments\njava -jar "$JAR_PATH" "$@"' | sudo tee /usr/local/bin/task-cli > /dev/null && sudo chmod +x /usr/local/bin/task-cli
```

### Usage

You can now use the `task-cli` command to manage your tasks.

#### Add a Task

```sh
task-cli add "Buy books"
```

#### Update a Task

```sh
task-cli update 1 "Buy more books"
```

#### Delete a Task

```sh
task-cli delete 1
```

#### Mark a Task as In-Progress

```sh
task-cli mark-in-progress 1
```

#### Mark a Task as Done

```sh
task-cli mark-done 1
```

#### List All Tasks

```sh
task-cli list
```

## Customization

To customize the CLI tool, you can modify the `task-cli` script:

1. Open the `task-cli` script located in `/usr/local/bin/`:

```sh
sudo nano /usr/local/bin/task-cli
```

2. Update the `JAR_PATH` variable to point to your JAR file location:

```sh
JAR_PATH="/path/to/your/Tasker/build/libs/Tasker-0.0.1-SNAPSHOT.jar"
```

3. Save and exit the editor.

## Contributing

Feel free to fork this repository and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License.
```

This README provides a comprehensive guide on how to use and customize the Tasker CLI tool.
