Quiz App
- Uses MVVM (Model, View, View-Model) architecture
- With data binding library
- MySQL
- Retrofit
- Create our own API in PHP
- POJO (Plain Old Java Object)

Recap on MVVM Layers:

View (Activity / Fragment)
	<=> MVVM
		Model: This layer is responsible for the abstraction of the 		date sources. Model and ViewModel work together to get 		and save the data.
		View: The purpose of this layer is to inform the VieModel 		about the user’s action. This layer observers the 				ViewModel and does not contain any kind of application 		logic.
		ViewModel: it exposes those data streams which are 			relevant to the view. Moreover, it serves as a link between 		the model and the view.
		=> Repository
			=> Local Data Source (ROOM DataBase
				(SQLite <=> DAO)
			=> Remote Data Source (API/JSON)
				(Web Service <=> API)  

This application has the following processes:
1. Create our local database (MYSQL)
2. Create our own API
3. Fetch the JSON response from database
4. Using Retrofit to create Java objects (POJO)
5. Display questions in Android App
6. Follow MVVM Architecture.

Steps:
1. Download XAMPP from Apache Friends (https://www.apachefriends.org)
2. Start Apache server and the MySQL server
3. Type “127.0.0.1” into Chrome browser
4. Create a database with 7 columns
    1. 1st => id and is primary with AI (automatic integral) enabled
    2. 2nd -> 5th => options as archer
    3. 6th  => result
5. Insert a question
6. Open a text editor to create an API (a set of rules or protocols that allows for external application to access information from an SQL database) this enables developers from updating/deleting databases without UI.
7. Create a php file using text editor which would be our API
8. Copy and paste the php api file into XAMPP> htdocs>Newfolder (renamed to quiz)
9. Then within chrome type the following localhost/quiz which should then show the PHP.
10. If you get error 500 when opening the php file, it’s probably syntax error which I resolved.
11. Need to also include the port for the localhost during the mysqli_connect(“localhost”,”root”,””,”sxxx”,”3306”) port 3306 can be something else though

Using retrofit
1> Retrofit is used for pulling data from web services like data classes and objects (POJO = plain old Java objects)  
Data Classes: POJO is for fetching response we need that automatically parse the JSON data using GSON in the background. We just need to create this POJO class. For creating POJO class first method is defining each and every variable by ourself and other best and fast method is using http:// www.jsonschema2pojo.org/ platform. To serialize JSON we require a converter.
2> API service interface. We need to create an interface to define our different methods that will be used for network transactions.
3> Retrofit instance. Since we are using retrofit for network calls. Let’s create a class that provides us the instance of the retrofit.

JSON Syntax
What’s JSON: JSON stands for JavaScript Object Notation. It is an independent data exchange format.

JSON Elements:
A JSON file consist of many components:
1. Array([): in a JSON file, square bracket represents a JSON object
    1. Arrays in JSON are almost the same as arrays in JavaScript. In JSON , array values must be type string, number, object, array, boolean, or null. In a JSON file, square bracket [] represents an array.
2. Objects({): in a JSON file, curly bracket representation a JSON object
    1. JSON object literals are surround by curly braces {}. JSON object literals contains key/value pairs. Keys and values are separated by a colon.
        1. Keys must be strings, and values must be a valid JSON data type.
        2. Each key/value pari is separated by a comma
3. Key: A JSON object contains a key that is just a string. Pairs of key/value make up a JSON object.
    1. {“name”:”heal”}
        1. In JSON, values must be one of the following data types: string, number, object, array, boolean, null. 
        2. In JSON, string values must be written with double quotes.

The reason for a GSON Converter:
A converter which uses Gson for Serialization to and from JSON. 
Used to convert Java objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object.
For this purpose, Gson provides several built in serializers and deserializers. A serializer allows to convert a Json string to corresponding Java type. A deserializers allows to convert from Java to a JSON representation.
A default Gson instance will be created or one can be configured and passed to the GsonConverterFactory to further control the serialization.

Steps for this project:
1. Create a project folder called model
    1. Create Question class (our model class)
        1. Copy the JSON output from the XAMPP PHP file and use a converter JSON 2 POJO to create the model code class
        2. Import all the files into the build.gradle.
            1. Lifecycle https://developer.android.com/jetpack/androidx/releases/lifecycle
            2. Retrofit https://square.github.io/retrofit/
    2. Create QuestionList class (because our model is an array)
2. Create a project folder called retrofit
    1. Create QuestionsAPI class which will be used to define the structure and behavior of network requests to a RESTful API. Acts as a bridge between android app and the web service.
    2. Create a RetrofitInstance class which apply the base Url and create an instance for retrofit
3. Create a project folder called repository
    1. Create a class QuizRepository which will interface with the API service interfaces handling data retrieval and operations.
4. Create a project folder called view model
    1. Create a class QuizViewModel which will implement and extend the ViewModel with LiveData
5. We will work on MainActivity and XML
    1. Go to build.gradle and add the DataBinding = true
    2. Create a new resource file within drawable gradient_back
    3. Update layout with RadioGroup
    4. Go to main activity and including binding
6. Create a new XML files within XML folder for security guidelines
        1. Rename the XML to: <network-security-config>  </network-security-config>
        2. Add to the Android manifest as well
7. Go to the RetrofitInstance class
    1. You need to change the baseURL to 10.0.2.2 which is the special IP address for the emulator as a look back.
8. Create an empty views activity to display final screen.

Credits go to Abbass Masri
from The Complete Android 14 Developer Course
