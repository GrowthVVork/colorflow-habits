# colorflow-habits
ColorFlow Habits is a visual task tracking app that turns your daily activities into a vivid color spectrum, offering a captivating and motivating way to monitor your progress and habits throughout the year.

## FEATURES -
1. UI
	Graph
	User Login

2. Backend
	- GET/user (getting user info)
	- POST/user (new user)
	- PUT/user (update user)
	- DEL/user (delete user)
	- GET/graph (pull all info, GraphType)
	- GET/tasks (get task)
	- POST/task (new task)
	- PUT/task (update task)
	- DEL/task (delete task)
	
3. Logic/Business 
	* If task is deleted do either of 2 options
		Delete with entire history
		Delete while retaining history
	* Color key : Mapping options
	* Type of graph : ADVANCE FEATURE
	* User authentication

## Steps to run UI locally -
To run your project, navigate to the directory and run one of the following yarn commands.

- cd colorflow-ui
- yarn android
- yarn ios # you need to use macOS to build the iOS project - use the Expo app if you need to do iOS development without a Mac
- yarn web

## Steps to run backend locally -
To run your project, navigate to the directory and run execute following line in your Java IDE.

- cd backend
- Build & Run ColorflowApplication

## NOTE :
- For backend to run, MySQL server should be up & running, listening at `localhost:3306` having colorflow schema with appropriate username & password as defined in application properties.
- For frontend to run, there might be dependencies missing initally which can't be resolved by yarn and require running `npx expo install react-native-web@~0.19.6 react-dom@18.2.0`

